package java112.analyzer;


import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.util.*;


/**
 * @author Eric Knapp
 * class AnalyzersBuilder
 */
public class AnalyzersBuilder {

    public static List<TokenAnalyzer> createFileAnalyzers(Properties properties, String analyzersListPath) {

        List<TokenAnalyzer> analyzers = null;
        try {

            analyzers = loadAnalyzers(properties, analyzersListPath);

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (NoSuchMethodException noSuchMethod) {
            noSuchMethod.printStackTrace();
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return analyzers;
    }


    /**
     * TODO: comment
     */
    private static List<TokenAnalyzer> loadAnalyzers(Properties properties, String analyzersListPath)
    throws Exception {

        List<TokenAnalyzer> analyzers = new ArrayList<>();

        for (String analyzerString : loadAnalyzerList(analyzersListPath)) {
            Class one = Class.forName(analyzerString);
            Constructor constructor = one.getConstructor(Properties.class);
            TokenAnalyzer analyzer = (TokenAnalyzer)constructor.newInstance(properties);

            analyzers.add(analyzer);
        }

        return analyzers;
    }


    private static List<String> loadAnalyzerList(String analyzersListPath) {

        List<String> analyzerList = null;

        URL analyzerListURL = "".getClass().getResource(analyzersListPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(analyzerListURL.getPath()))) {

            analyzerList = filterAnalyzerList(reader);
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
    private static List<String> filterAnalyzerList(BufferedReader reader) throws IOException {

        List<String> analyzerList = new ArrayList<>();
        while (reader.ready()) {
            String line = reader.readLine();

            if (line.isEmpty()) {
                continue;
            }


            Character firstCharacter = line.trim().charAt(0);
            if (firstCharacter != '#') {
                analyzerList.add(line);
            }
        }
        return analyzerList;
    }
}
