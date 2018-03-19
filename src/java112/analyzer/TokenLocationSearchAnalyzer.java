package java112.analyzer;

import java.io.*;
import java.util.*;
import java.net.*;



/**
 * @author Eric Knapp
 * class TokenLocationSearchAnalyzer
 */
public class TokenLocationSearchAnalyzer implements TokenAnalyzer {

    private static final int OUTPUT_LINE_MAXIMUM = 79;

    private Map<String, List<Integer>> foundLocations;
    private Properties properties;
    private int currentTokenLocation;

    /**
     * Constructor for TokenLocationSearchAnalyzer
     */
    public TokenLocationSearchAnalyzer() {
        foundLocations = new TreeMap<>();
    }

    public TokenLocationSearchAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        loadFoundLocationsMap();
    }

    /**
     *
     */
    public Map<String, List<Integer>> getFoundLocations() {
        return foundLocations;
    }

    /**
     *
     */
    public void processToken(String token) {
        currentTokenLocation += 1;

        if (foundLocations.containsKey(token)) {
            foundLocations.get(token).add(currentTokenLocation);
        }
    }

    /**
     *
     */
    public void generateOutputFile(String inputFilePath) {

        String outputFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.token.search.locations");

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            writeFoundLocations(writer);

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     *
     */
    private void writeFoundLocations(PrintWriter writer) {

        for (Map.Entry<String, List<Integer>> entry : foundLocations.entrySet()) {
            writeCurrentSearchTokenLocations(entry, writer);
        }

    }

    /**
     *
     */
    private void writeCurrentSearchTokenLocations(Map.Entry<String, List<Integer>> tokenLocations, PrintWriter writer) {

        writeSearchToken(tokenLocations, writer);

        writeSearchLocations(tokenLocations, writer);
    }

    /**
     *
     */
    private void writeSearchLocations(Map.Entry<String, List<Integer>> tokenLocations, PrintWriter writer) {

        List<Integer> locations = tokenLocations.getValue();

        String outputLine = "[";
        String nextLocation = null;

        for (Integer location : locations) {
            nextLocation = location.toString();

            int proposedLineLength = outputLine.length() + nextLocation.length();

            if (proposedLineLength > OUTPUT_LINE_MAXIMUM) {
                writer.println(outputLine.trim());
                outputLine = nextLocation + ", ";
            } else {
                outputLine += nextLocation + ", ";
            }
        }

        if (outputLine.length() > 1) {
            writer.print(outputLine.substring(0, outputLine.length() - 2));
        } else {
            writer.print(outputLine.trim());
        }

        writer.println("]");
        writer.println();

    }

    /**
     * TODO: comment
     */
    public void writeSearchToken(Map.Entry<String, List<Integer>> tokenLocations, PrintWriter writer) {

        writer.print(tokenLocations.getKey());
        writer.println(" =");

    }


    /**
     *
     */
    private void loadFoundLocationsMap() {

        String searchTokensClasspath = properties.getProperty("classpath.search.tokens");
        URL searchTokensURL = this.getClass().getResource(searchTokensClasspath);
        String searchTokensFilePath = searchTokensURL.getPath();

        try (BufferedReader searchTokensReader = new BufferedReader(new FileReader(searchTokensFilePath))) {
            readSearchTokens(searchTokensReader);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     *
     */
    private void readSearchTokens(BufferedReader reader) throws IOException {
        while (reader.ready()) {
            String line = reader.readLine();
            if (!line.isEmpty()) {
                foundLocations.put(line.trim(), new ArrayList<>());
            }
        }
    }
}



