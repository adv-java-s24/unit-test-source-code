package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.*;

/**
 * @author Eric Knapp
 * class DistinctTokenCountsAnalyzer
 *
 */
public class DistinctTokenCountsAnalyzer implements TokenAnalyzer {

    private Properties properties;
    private Map<String, Counter> distinctTokenCounts;

    /**
     * Constructor for DistinctTokenCountsAnalyzer
     */
    public DistinctTokenCountsAnalyzer() {
        distinctTokenCounts = new TreeMap<>();
    }

    /**
     * Constructor for DistinctTokenCountsAnalyzer
     */
    public DistinctTokenCountsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     *
     */
    public Map<String, Counter> getDistinctTokenCounts() {
        return distinctTokenCounts;
    }

    /**
     *
     */
    public void processToken(String token) {

        if (distinctTokenCounts.containsKey(token)) {
            distinctTokenCounts.get(token).increment();
        } else {
            distinctTokenCounts.put(token, new Counter());
        }
    }

    /**
     *
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.distinct.counts");

        try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)));) {

            writeTokenCounts(output);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void writeTokenCounts(PrintWriter output) {

        for (Map.Entry<String, Counter> entry : distinctTokenCounts.entrySet()) {
            output.println(entry.getKey() + "\t" + entry.getValue());
        }
    }


}









