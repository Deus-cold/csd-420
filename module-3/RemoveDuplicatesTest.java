// Samir Rodriguez
// Module 3.2 Assignment
import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        // Fill originalList with 50 random integers from 1 to 20
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Display original list
        System.out.println("Original List (with duplicates):");
        System.out.println(originalList);

        // Get new list without duplicates
        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        // Display list without duplicates
        System.out.println("\nList after removing duplicates:");
        System.out.println(noDuplicates);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}