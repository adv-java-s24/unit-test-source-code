package java112.analyzer;

import java.io.*;
import java.util.*;

/**
 * @author Eric Knapp
 * class FileSummaryAnalyzer
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;

    /**
     * Constructor for FileSummaryAnalyzer
     */
    public FileSummaryAnalyzer() {

    }

    /**
     *
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }

    /**
     *
     */
    public void processToken(String token) {
        totalTokensCount += 1;
    }

    /**
     * TODO: comment
     */
    public void generateOutputFile(String inputFilePath, String outputFilePath) {
        System.out.println("totalTokensCount: " + totalTokensCount);

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeSummary(inputFilePath, writer);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     *
     */
    private void writeSummary(String inputFilePath, PrintWriter writer) {

        File inputFile = new File(inputFilePath);
        Date lastModifiedDate = new Date(inputFile.lastModified());

        writer.println("Application: File Magic");
        writer.println("Author: Eric Knapp");
        writer.println("Auther email: eknapp@madisoncollege.edu");
        writer.println("File: " + inputFilePath);
        writer.println("Date of analysis: " + new Date());
        writer.println("Last Modified:    " + lastModifiedDate);
        writer.println("File Size: " + inputFile.length());
        writer.println("File URI: " + inputFile.toURI());
        writer.println("Total Tokens: " + totalTokensCount);

    }

    public String toString() {
        return "FileSummaryAnalyzer: total count: " + totalTokensCount;
    }
}