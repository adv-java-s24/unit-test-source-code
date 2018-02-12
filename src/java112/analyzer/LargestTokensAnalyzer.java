package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Eric Knapp
 * class LargestTokensAnalyzer
 *
 */
public class LargestTokensAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Set<String> largestTokens;
    private int minimumTokenLength;

    /**
     * Constructor for LargestTokensAnalyzer
     */
    public LargestTokensAnalyzer() {
        largestTokens = new TreeSet<String>();
    }

    /**
     * Constructor for LargestTokensAnalyzer
     */
    public LargestTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
        loadBigWordMinimumLength();
    }

    private void loadBigWordMinimumLength() {
        String minimumLengthString = properties.getProperty("largest.words.minimum.length");
        try {
            minimumTokenLength = Integer.parseInt(minimumLengthString);
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            //set default to 15 as a reasonable value
            minimumTokenLength = 15;
        }

    }

    public Set<String> getLargestTokens() {
        return largestTokens;
    }

    public void processToken(String token) {
        if (token.length() >= minimumTokenLength) {
            largestTokens.add(token);
        }
    }

    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.largest.words");
        PrintWriter output = null;

        try {
            output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));

            writeBigTokens(output);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            output.close();
        }
    }

    private void writeBigTokens(PrintWriter output) {

        for (String token : largestTokens) {
            output.println(token);
        }
    }

}
