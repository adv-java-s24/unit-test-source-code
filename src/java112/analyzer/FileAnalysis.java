package java112.analyzer;


import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;

import java112.utilities.*;


/**
 * @author Eric Knapp
 * class FileAnalysis
 */
public class FileAnalysis implements PropertiesLoader {

    private static final int VALID_ARGUMENT_COUNT = 3;
    private List<TokenAnalyzer> analyzers;


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


        long start = System.currentTimeMillis();
        String inputFilePath = arguments[0];
        String propertiesFilePath = arguments[1];
        String analyzersListPath = arguments[2];

        Properties properties = loadProperties(propertiesFilePath);

        createFileAnalyzers(properties, analyzersListPath);
        openInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);

        long end = System.currentTimeMillis();
        double elapsed = (double)(end - start) / 1000;
        System.out.println("Elapsed time: " + elapsed);
    }


    private void createFileAnalyzers(Properties properties, String analyzersListPath) {

        analyzers = AnalyzersBuilder.createFileAnalyzers(properties, analyzersListPath);

    }

    /**
     *
     */
    private void openInputFile(String inputFilePath) {

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

            if ((token.isEmpty() || Character.isDigit(token.charAt(0)))) {
                continue;
            }

            processToken(token);
        }
    }


    private void processToken(String token) {

        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.processToken(token);
        }
    }


    private void writeOutputFiles(String inputFilePath) {

        for (TokenAnalyzer analyzer : analyzers) {
            analyzer.generateOutputFile(inputFilePath);
        }
    }
}
