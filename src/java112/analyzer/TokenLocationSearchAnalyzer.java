package java112.analyzer;

import java.io.*;
import java.util.*;



/**
 * @author Eric Knapp
 * class TokenLocationSearchAnalyzer
 */
public class TokenLocationSearchAnalyzer {

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

}