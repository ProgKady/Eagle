package eagle;


import java.io.*;

public class FileConverter {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFilePath = "C:\\Users\\Ahmed.ElKady\\Desktop\\RECIPE.txt";        // Original file
        String outputFilePath = "C:\\Users\\Ahmed.ElKady\\Desktop\\RECIPE.xlsb";       // New file with different extension

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // preserve line breaks
            }
            System.out.println("File saved as: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}
