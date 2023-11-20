package javabasics.collection;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
  public static void main(String[] args) {
    TreeMap<Integer, String> students = new TreeMap<>();

    students.put(101, "John");
    students.put(103, "Alice");
    students.put(102, "Bob");
    students.put(105, "Eva");

    // TreeMap stores data in the form of key-value pairs
    System.out.println("\nKey-Value pairs in the TreeMap:");
    for (Map.Entry<Integer, String> entry : students.entrySet()) {
      System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue());
    }

    // TreeMap contains unique keys
    // Attempting to add a duplicate key will replace the existing value
    students.put(101, "Mike");

    System.out.println("\nUpdated TreeMap after adding a new key:");
    System.out.println("TreeMap: " + students);

    // TreeMap does not allow any key to be null
    // Uncommenting the next line will result in a NullPointerException
    // students.put(null, "Some Value");

    // TreeMap can have multiple null values
    students.put(106, null);
    students.put(107, null);

    System.out.println("\nTreeMap with null values:");
    System.out.println("TreeMap: " + students);

    // TreeMap maintains elements in the order of keys in ascending order
    System.out.println("\nOrder of elements in the TreeMap:");
    for (Map.Entry<Integer, String> entry : students.entrySet()) {
      System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue());
    }
  }
}
