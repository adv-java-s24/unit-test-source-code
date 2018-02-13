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

        List<String> analyzerList = new ArrayList<>();

        URL analyzerListURL = "".getClass().getResource(analyzersListPath);

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
}

