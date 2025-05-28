// Samir Rodriguez
// Module 5 Assignment
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSorter {

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(); // normalize to lowercase
                words.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return words;
    }

    public static Set<String> getUniqueWords(List<String> words) {
        return new TreeSet<>(words); // TreeSet sorts and removes duplicates
    }

    public static void displayWords(Set<String> words) {
        System.out.println("Ascending Order:");
        for (String word : words) {
            System.out.print(word + " ");
        }

        System.out.println("\n\nDescending Order:");
        List<String> descList = new ArrayList<>(words);
        Collections.reverse(descList);
        for (String word : descList) {
            System.out.print(word + " ");
        }
    }

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";
        List<String> words = readWordsFromFile(filename);
        Set<String> uniqueWords = getUniqueWords(words);
        displayWords(uniqueWords);
    }
}