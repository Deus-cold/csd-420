// Samir Rodriguez
// Module 6.2 Assignment 

import java.util.Comparator; 



public class GenericBubbleSort {

    //  Method 1: Uses Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }


    // Method 2: Uses Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }


    // Helper to print array
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println(); 
    }

    //Test it all
    public static void main(String[] args) {
        //Using Comparable (Natural Ordering)
        Integer [] intArray = {5, 2, 9, 1, 3};
        System.out.println("Before sorting (Comparable):");
        printArray(intArray);
        bubbleSort(intArray);
        System.out.println("After sorting (Comparable): ");
        printArray(intArray);

        // Using Comparator (Custom Order)
        String [] strArray = {"banana", "apple", "cherry", "date"};
        System.out.println("\nBefore sorting (Comparator):");
        printArray(strArray);
        bubbleSort(strArray, (s1, s2) -> s1.compareTo(s2)); // It is ascending alphabetical
        System.out.println("After sorting (Comparator):");
        printArray(strArray);

    }

}
