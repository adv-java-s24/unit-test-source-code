package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.*;

/**
 * @author Eric Knapp
 * class TokenLengthsAnalyzer
 */
public class TokenLengthsAnalyzer implements TokenAnalyzer {

    private Map<Integer, Counter> tokenLengths;
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

    public Map<Integer, Counter> getTokenLengths() {
        return tokenLengths;
    }

    public void processToken(String token) {

        Integer tokenLength = token.length();

        if (tokenLengths.containsKey(tokenLength)) {
            tokenLengths.get(tokenLength).increment();
        } else {
            tokenLengths.put(tokenLength, new Counter());
        }
    }

    public void generateOutputFile(String inputFilePath) {

        String oututFilePath = properties.getProperty("output.directory") + properties.getProperty("output.file.token.lengths");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(oututFilePath)))) {

            writeTokenLengthsCounts(output);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void writeTokenLengthsCounts(PrintWriter output) {
        for (Map.Entry<Integer, Counter> entry : tokenLengths.entrySet()) {
            output.println(entry.getKey() + "\t" + entry.getValue());
        }

    }
}










