package java112.analyzer;


import java.io.*;
import java.util.*;

import java112.utilities.*;


/**
 * @author Eric Knapp
 * class FileAnalysis
 */
public class FileAnalysis implements PropertiesLoader {

    private static final int VALID_ARGUMENT_COUNT = 1;
    private FileSummaryAnalyzer summaryAnalyzer;
    private DistinctTokensAnalyzer distinctAnalyzer;


    /**
     * Constructor for FileAnalysis
     */
    public FileAnalysis() {
    }


    /**
     *
     */
    public void analyze(String[] arguments) {
        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter the file to analyze.");
            return;
        }


        String inputFilePath = arguments[0];

        createFileAnalyzers();
        analyzeInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);
    }


    private void createFileAnalyzers() {
        summaryAnalyzer = new FileSummaryAnalyzer();
        distinctAnalyzer = new DistinctTokensAnalyzer();
    }


    /**
     *
     */
    private void analyzeInputFile(String inputFilePath) {
        System.out.println("inputFilePath: " + inputFilePath);

        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFilePath))) {

            readInputFile(fileReader);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * TODO: comment
     */
    private void readInputFile(BufferedReader reader) throws IOException {

        while (reader.ready()) {
            tokenizeFileLine(reader.readLine());
        }
    }


    /**
     *
     */
    private void tokenizeFileLine(String inputLine) {
        String[] tokens = inputLine.split("\\W");

        for (String token : tokens) {

            if (token.isEmpty()) {
                continue;
            }

            char firstCharacter = token.charAt(0);
            if (Character.isDigit(firstCharacter)) {
                return;
            }


            summaryAnalyzer.processToken(token);
            distinctAnalyzer.processToken(token);
        }
    }


    private void writeOutputFiles(String inputFilePath) {
        summaryAnalyzer.generateOutputFile(inputFilePath, "output/summary.txt");
        distinctAnalyzer.generateOutputFile(inputFilePath, "output/distinct_tokens.txt");
    }
}
