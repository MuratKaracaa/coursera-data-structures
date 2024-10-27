


import data_structures.week_3.hash_substring;
import data_structures.week_4.tree_orders;

import java.io.*;
import java.util.Objects;

public class TestRunner {

    public static void main(String[] args) throws IOException {
        // File paths
        String inputFilePath = "input.txt";     // Path to the input file
        String outputFilePath = "output.txt";   // Path where the output will be written
        String expectedFilePath = "expected.txt"; // Path to the expected result file

        // Redirect input and output for the test
        runTest(inputFilePath, outputFilePath);

        // Compare the result with the expected output
        if (compareFiles(outputFilePath, expectedFilePath)) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    private static void runTest(String inputFilePath, String outputFilePath) throws IOException {
        // Set input file to System.in
        System.setIn(new FileInputStream(inputFilePath));
        // Set output file to System.out
        System.setOut(new PrintStream(new FileOutputStream(outputFilePath)));

        // Call the existing code (main method of merging_tables)
         tree_orders.main(new String[0]);
    }

    // Function to compare output file with expected result file
    private static boolean compareFiles(String outputFilePath, String expectedFilePath) throws IOException {
        BufferedReader outputReader = new BufferedReader(new FileReader(outputFilePath));
        BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath));

        String outputLine, expectedLine;
        while ((outputLine = outputReader.readLine()) != null && (expectedLine = expectedReader.readLine()) != null) {
            if (!Objects.equals(outputLine, expectedLine)) {
                outputReader.close();
                expectedReader.close();
                return false; // Mismatch
            }
        }

        boolean bothEnd = outputReader.readLine() == null && expectedReader.readLine() == null;

        outputReader.close();
        expectedReader.close();

        return bothEnd;
    }
}
