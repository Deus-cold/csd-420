// Samir Rodriguez
// Module 5 Assignment
import java.util.*;

public class WordSorterTest {

    public static void testUniqueSorting() {
        List<String> testInput = Arrays.asList("Apple", "banana", "apple", "Banana", "orange");
        Set<String> expected = new TreeSet<>(Arrays.asList("apple", "banana", "orange"));

        Set<String> result = WordSorter.getUniqueWords(testInput);

        if (result.equals(expected)) {
            System.out.println("testUniqueSorting passed");
        } else {
            System.out.println(" testUniqueSorting failed");
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + result);
        }
    }

    public static void main(String[] args) {
        testUniqueSorting();
    }
}