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
        System.out.println(foundLocations);

        String outputFilePath = properties.getProperty("output.directory")
                + properties.getProperty("output.file.token.search.locations");

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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



