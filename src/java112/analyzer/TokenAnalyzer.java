package java112.analyzer;


/**
 * @author Eric Knapp
 *
 */
public interface TokenAnalyzer {

    void processToken(String token);
    void generateOutputFile(String inputFilePath, String outputFilePath);
}

