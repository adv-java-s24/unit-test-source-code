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
        distinctTokenCounts = new TreeMap<String, Counter>();
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
    public Map getDistinctTokenCounts() {
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

        //topWordCounts();
        //writeSortedTokenCounts();
    }

    private void writeTokenCounts(PrintWriter output) {

        for (Map.Entry<String, Counter> entry : distinctTokenCounts.entrySet()) {
            output.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

    private void topWordCounts() {

        String key = null;
        int biggest = 0;
        Set<Counter> sizes = new TreeSet<Counter>();
        for (Map.Entry<String, Counter> entry : distinctTokenCounts.entrySet()) {
            if (entry.getValue().getCount() > biggest) {
                biggest = entry.getValue().getCount();
                key = entry.getKey();
            }
            sizes.add(entry.getValue());
        }

        System.out.println(sizes);
        System.out.println("Key: " + key + ", Value: " + biggest);
    }

    private void writeSortedTokenCounts() {
        String sortedFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.sorted.token.count");

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(sortedFilePath)))) {
            writeSortedOutput(writer);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * TODO: comment
     */
    private void writeSortedOutput(PrintWriter writer) {
        Map<String, Counter> sortedTokenCountMap = MapUtilities.sortByValue(distinctTokenCounts);

        for (Map.Entry<String, Counter> entry : sortedTokenCountMap.entrySet()) {
            writer.println(entry.getKey() + "\t" + entry.getValue());
        }

    }



}









