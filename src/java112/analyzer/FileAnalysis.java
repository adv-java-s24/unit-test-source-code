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

    private static final int VALID_ARGUMENT_COUNT = 2;
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

        createFileAnalyzers(propertiesFilePath);
        openInputFile(inputFilePath);
        writeOutputFiles(inputFilePath);

        long end = System.currentTimeMillis();
        double elapsed = (double)(end - start) / 1000;
        System.out.println("Elapsed time: " + elapsed);
    }


    private void createFileAnalyzers(String propertiesFilePath) {

        analyzers = new ArrayList<>();

        Properties properties = loadProperties(propertiesFilePath);

        try {

            loadAnalyzers(properties);
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (NoSuchMethodException noSuchMethod) {
            noSuchMethod.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        // analyzers.add(new FileSummaryAnalyzer(properties));
        // analyzers.add(new DistinctTokensAnalyzer(properties));
        // analyzers.add(new DistinctTokenCountsAnalyzer(properties));
        // analyzers.add(new LargestTokensAnalyzer(properties));
    }


    /**
     * TODO: comment
     */
    public void loadAnalyzers(Properties properties)
    throws Exception {

        List<String> analyzerList = loadAnalyzerList();

        System.out.println(analyzerList);

        for (String analyzerString : analyzerList) {
            Class one = Class.forName(analyzerString);
            Constructor constructor = one.getConstructor(Properties.class);
            TokenAnalyzer analyzer = (TokenAnalyzer)constructor.newInstance(properties);

            analyzers.add(analyzer);
        }
    }


    public List<String> loadAnalyzerList() {

        List<String> analyzerList = new ArrayList<>();

        URL analyzerListURL = this.getClass().getResource("/analyzers.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(analyzerListURL.getPath()))) {

            while (reader.ready()) {
                analyzerList.add(reader.readLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return analyzerList;
    }


    /**
     *
     */
    private void openInputFile(String inputFilePath) {

        // System.out.println("inputFilePath: " + inputFilePath);
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
