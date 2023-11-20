package javabasics.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList<String> fruits = new ArrayList<>();

    // Adding duplicate elements to the ArrayList
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Apple");
    fruits.add("Orange");

    // Maintaining the order of elements as they are added
    System.out.println("Elements in the ArrayList:");
    for (String fruit : fruits) {
      System.out.println(fruit);
    }

    // Checking if ArrayList contains duplicate elements
    if (fruits.size() != new ArrayList<>(new HashSet<>(fruits)).size()) {
      System.out.println("\nThe ArrayList contains duplicate elements.");
    } else {
      System.out.println("\nThe ArrayList does not contain duplicate elements.");
    }

    // Allowing random access as it stores data based on indexes
    System.out.println("\nRandom access to elements in the ArrayList:");
    System.out.println("Element at index 1: " + fruits.get(1));
    System.out.println("Element at index 2: " + fruits.get(2));
  }
}
