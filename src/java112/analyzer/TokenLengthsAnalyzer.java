package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Eric Knapp
 * class TokenLengthsAnalyzer
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    private static final int HISTOGRAM_WIDTH = 76;

    private Map<Integer, Integer> tokenLengths;
    private Properties properties;


    /**
     * Constructor for TokenLengthsAnalyzer
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<>();
    }


    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    public Map<Integer, Integer> getTokenLengths() {
        return tokenLengths;
    }


    public void processToken(String token) {

        Integer tokenLength = token.length();

        if (tokenLengths.containsKey(tokenLength)) {
            tokenLengths.replace(tokenLength, tokenLengths.get(tokenLength) + 1);
        } else {
            tokenLengths.put(tokenLength, new Integer(1));
        }
    }


    public void generateOutputFile(String inputFilePath) {
        writeTokenLengthsData();
        writeTokenLengthsHistogram();
    }


    private void writeTokenLengthsData() {
        String oututFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.token.lengths");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(oututFilePath)))) {

            writeTokenLengthsCounts(output);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private void writeTokenLengthsCounts(PrintWriter output) {
        for (Map.Entry <Integer, Integer> entry : tokenLengths.entrySet()) {
            output.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    private void writeTokenLengthsHistogram() {

        String outputFilePath = properties.getProperty("output.directory")
        + properties.getProperty("output.file.token.lengths.histogram");

        int maximumTokenLength = Collections.max(tokenLengths.values());
        double tokensPerAsterisk = (double)maximumTokenLength / (double)HISTOGRAM_WIDTH;

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeHistogram(output, tokensPerAsterisk);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     *
     */
    private void writeHistogram(PrintWriter output, double tokensPerAsterisk) {

        for (Map.Entry<Integer, Integer> entry : tokenLengths.entrySet()) {
            Integer tokenLength = entry.getKey();
            Integer tokenLengthCount = entry.getValue();
            output.print(String.format("%1$-4s", tokenLength));
            output.println(writeAsterisksForLength(tokenLengthCount, tokensPerAsterisk));
        }

        output.println();
        output.println("Key: * ~= " + Math.round(tokensPerAsterisk)  + " tokens");

    }

    /**
     * TODO: comment
     */
    public String writeAsterisksForLength(Integer tokenLengthCount, double tokensPerAsterisk) {

        int lengthCount = tokenLengthCount.intValue();
        double asteriskCount = (double)lengthCount / tokensPerAsterisk;

        if (asteriskCount < 1) {
            return "*";
        }

        String asterisks = String.join("", Collections.nCopies((int)Math.round(asteriskCount), "*"));
        return asterisks;
    }
}




















