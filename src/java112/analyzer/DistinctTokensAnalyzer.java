package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Eric Knapp
 *
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;
    private Properties properties;

    /**
     * Constructor for DistinctTokensAnalyzer
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
    }

    public DistinctTokensAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     *
     */
    public Set<String> getDistinctTokens() {
        return distinctTokens;
    }




    public void processToken(String token) {
        distinctTokens.add(token);
    }


    /**
     *
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory") +
                properties.getProperty("output.file.distinct");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            //writeDistinctTokensLambda(writer);
            writeDistinctTokens(writer);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * wha?
     */
    private void writeDistinctTokens(PrintWriter writer) {

        long start = System.currentTimeMillis();

        for (String token : distinctTokens) {
            writer.println(token);
        }

        long end = System.currentTimeMillis();
        System.out.println("fore: " + (end - start));
    }

    /**
     * TODO: comment
     */
    public void writeDistinctTokensLambda(PrintWriter writer) {

        long start = System.currentTimeMillis();

        distinctTokens.forEach(token -> writer.println(token));

        long end = System.currentTimeMillis();
        System.out.println("lambda: " + (end - start));
    }


    /**
     * huh
     */
    public String toString() {
        return "DistinctTokensAnalyzer: distinct count: " + distinctTokens.size();
    }
}
