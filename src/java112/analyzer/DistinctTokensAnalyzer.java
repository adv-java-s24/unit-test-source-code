package java112.analyzer;


import java.io.*;
import java.util.*;

import java112.utilities.*;


/**
 * @author Eric Knapp
 *
 */
public class DistinctTokensAnalyzer implements TokenAnalyzer {

    private Set<String> distinctTokens;


    /**
     * Constructor for DistinctTokensAnalyzer
     */
    public DistinctTokensAnalyzer() {
        distinctTokens = new TreeSet<>();
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
    public void generateOutputFile(String inputFilePath, String outputFilePath) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

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

        for (String token : distinctTokens) {
            writer.println(token);
        }
    }


    /**
     * huh
     */
    public String toString() {
        return "DistinctTokensAnalyzer: distinct count: " + distinctTokens.size();
    }
}
