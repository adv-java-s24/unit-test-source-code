package java112.analyzer;

import java.io.*;
import java.util.*;

import java112.utilities.*;

/**
 * @author Eric Knapp
 * class TokenLengthsAnalyzer
 */
public class TokenLengthsAnalyzer {

    private Map<Integer, Counter> tokenLengths;
    private Properties properties;


    /**
     * Constructor for TokenLengthsAnalyzer
     */
    public TokenLengthsAnalyzer() {
        tokenLengths = new TreeMap<>();
    }

    public TokenLengthsAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }

}