// Samir Rodriguez
// Module 4.2 Assignment

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {

    public static void main(String[] args) {
        // Test with 50,000 integers
        System.out.println("Testing with 50,000 integers:");
        testLinkedListTraversal(50000);

        // Test with 500,000 integers
        System.out.println("\nTesting with 500,000 integers:");
        testLinkedListTraversal(500000);
    }

    public static void testLinkedListTraversal(int numElements) {
        // Create and populate the LinkedList with integers
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }

        // Test traversal using an iterator
        long startTime = System.nanoTime();
        traverseUsingIterator(list);
        long endTime = System.nanoTime();
        long iteratorTime = endTime - startTime;
        System.out.println("Time taken using Iterator: " + iteratorTime + " nanoseconds");

        // Test traversal using the get(index) method
        startTime = System.nanoTime();
        traverseUsingGet(list);
        endTime = System.nanoTime();
        long getTime = endTime - startTime;
        System.out.println("Time taken using get(index): " + getTime + " nanoseconds");

        // Comparing the results
        System.out.println("Time difference (get(index) - iterator): " + (getTime - iteratorTime) + " nanoseconds");
    }

    // Traverse the list using an iterator
    public static void traverseUsingIterator(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    // Traverse the list using the get(index) method
    public static void traverseUsingGet(LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
    }
}