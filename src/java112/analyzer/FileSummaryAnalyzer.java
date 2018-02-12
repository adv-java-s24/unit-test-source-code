package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * @author Eric Knapp
 * class FileSummaryAnalyzer
 */
public class FileSummaryAnalyzer implements TokenAnalyzer {

    private int totalTokensCount;
    private Properties properties;


    /**
     * Constructor for FileSummaryAnalyzer
     */
    public FileSummaryAnalyzer() {
    }

    public FileSummaryAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     *
     */
    public int getTotalTokensCount() {
        return totalTokensCount;
    }


    public void processToken(String token) {
        totalTokensCount += 1;
    }


    /**
     * TODO: comment
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory") +
                properties.getProperty("output.file.summary");

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

        String lastModifiedDate = null;
        String fileLength = null;
        String fileURI = null;

        if (inputFile.exists()) {
            lastModifiedDate = new Date(inputFile.lastModified()).toString();
            fileLength = "" + inputFile.length();
            fileURI = inputFile.toURI().toString();
        } else {
            lastModifiedDate = "Input file is missing.";
            fileLength = "Input file is missing";
            fileURI = "Input file is missing";
        }

        writer.println("Application: File Magic");
        writer.println("Author: Eric Knapp");
        writer.println("Auther email: eknapp@madisoncollege.edu");
        writer.println("File: " + inputFilePath);
        writer.println("Date of analysis: " + new Date());
        writer.println("Last Modified:    " + lastModifiedDate);
        writer.println("File Size: " + fileLength);
        writer.println("File URI: " + fileURI);
        writer.println("Total Tokens: " + totalTokensCount);
    }


    public String toString() {
        return "FileSummaryAnalyzer: total count: " + totalTokensCount;
    }
}
