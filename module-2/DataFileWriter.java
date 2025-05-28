// Samir Rodriguez
//Module 2.2 assignment
import java.io.*;
import java.util.Random;

public class DataFileWriter {
    public static void main(String[] args) {
        // Create random number generator
        Random random = new Random();
        
        // Generate an array of five random integers
        int[] randomIntegers = new int[5];
        for (int i = 0; i < randomIntegers.length; i++) {
            randomIntegers[i] = random.nextInt(100); // Random integer between 0 and 99
        }
        
        // Generate an array of five random double values
        double[] randomDoubles = new double[5];
        for (int i = 0; i < randomDoubles.length; i++) {
            randomDoubles[i] = random.nextDouble() * 100; // Random double between 0.0 and 100.0
        }
        
        // File to write data to
        File file = new File("Samir_datafile.dat");
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) { // 'true' for append mode
            // Write integers to file
            writer.write("Random Integers:\n");
            for (int i = 0; i < randomIntegers.length; i++) {
                writer.write(randomIntegers[i] + " ");
            }
            writer.write("\n");
            
            // Write doubles to file
            writer.write("Random Doubles:\n");
            for (int i = 0; i < randomDoubles.length; i++) {
                writer.write(randomDoubles[i] + " ");
            }
            writer.write("\n");

            System.out.println("Data written successfully to Samir_datafile.dat.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
