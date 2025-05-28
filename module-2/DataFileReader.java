//Samir Rodriguez
//Module 2.2 Assignment
import java.io.*;

public class DataFileReader {
    public static void main(String[] args) {
        // File to read data from
        File file = new File("Samir_datafile.dat");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}