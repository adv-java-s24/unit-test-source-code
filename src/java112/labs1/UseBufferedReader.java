package java112.labs1;


import java.io.*;
import java.util.*;


/**
 *  This class demonstrates the BufferedReader class.
 *
 *
 *@author     eknapp
 *@created    August 21, 2010
 */
public class UseBufferedReader {

    private static final int VALID_ARGUMENT_COUNT = 1;
    /**
     *  This List will keep track of all the tokens in the order that they
     *  are read from the file. Duplicates are allowed.
     */
    private List<String> tokens;
    /**
     *  This Set will hold all the unique tokens in the input file. There is
     *  no need to do anything special to reject duplicates, this is done
     *  automatically.
     */
    private Set<String> distinctTokens;


    /**
     * Basic constructor for UseBufferedReader
     */
    public UseBufferedReader() {
        tokens = new ArrayList<>();
        distinctTokens = new TreeSet<>();
    }


    /**
     *  The intial starting method
     * @param arguments the command line arguments
     */
    public void run(String[] arguments) {

        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter a file path.");
            return;
        }



        openInputFile(arguments[0]);
        printTokenList();
        printDistinctTokens();
    }


    /**
     *  This method opens the input file for reading.
     * @param filePath the file path to the input file
     */
    private void openInputFile(String filePath) {

        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filePath));

            readInputFile(input);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException inputOutputException) {
                inputOutputException.printStackTrace();
            }
        }
    }


    /**
     * Read through the input file and create a token array for each line.
     * @param input the BufferedReader for the input file
     */
    public void readInputFile(BufferedReader input) throws IOException {
        String inputLine = null;
        String[] tokenArray = null;

        while (input.ready()) {
            inputLine = input.readLine();
            tokenArray = inputLine.split("\\W");

            processTokenArray(tokenArray);
        }
    }


    /**
     * Loop through the token array for a line filtering out empty tokens.
     * @param tokenArray the array of tokens
     */
    public void processTokenArray(String[] tokenArray) {
        for (String token : tokenArray) {

            tokens.add(token);
            distinctTokens.add(token);
        }
    }


    /**
     *  This method prints the tokens
     */
    private void printTokenList() {

        System.out.println();
        System.out.println("####################");
        System.out.print("token list size: ");
        System.out.println(tokens.size());

        for (String token : tokens) {
            System.out.println(token);
        }
    }


    /**
     *  This method prints the distinctTokens
     */
    private void printDistinctTokens() {

        System.out.println();
        System.out.println("####################");
        System.out.print("distinct token list size: ");
        System.out.println(distinctTokens.size());

        for (String token : distinctTokens) {
            System.out.println(token);
        }
    }


    /**
     *  The main program for the UseBufferedReader class
     *
     *@param  arguments  The command line arguments
     *
     */
    public static void main(String[] arguments) {
        UseBufferedReader reader = new UseBufferedReader();
        reader.run(arguments);
    }
}
