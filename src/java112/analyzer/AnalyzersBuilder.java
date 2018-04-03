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
     *
     */
    private static List<TokenAnalyzer> loadAnalyzers(Properties properties, String analyzersListPath)
    throws Exception {

        List<TokenAnalyzer> analyzers = new ArrayList<>();

        for (String analyzerString : loadAnalyzerList(analyzersListPath)) {
            Class<?> one = Class.forName(analyzerString);
            Class<?>[] types = new Class[] { Properties.class };
            Constructor<?> constructor = one.getConstructor(types);
            TokenAnalyzer analyzer = (TokenAnalyzer)constructor.newInstance(properties);

            analyzers.add(analyzer);
        }

        return analyzers;
    }


    private static List<String> loadAnalyzerList(String analyzersListPath) {

        List<String> analyzerList = null;

        try (
            InputStream inputStream = "".getClass().getResourceAsStream(analyzersListPath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader)
        ) {

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
