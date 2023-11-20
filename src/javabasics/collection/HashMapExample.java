package javabasics.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    HashMap<String, String> capitalMap = new HashMap<>();

    // Adding key-value pairs to the HashMap
    capitalMap.put("USA", "Washington, D.C.");
    capitalMap.put("India", "New Delhi");
    capitalMap.put("France", "Paris");
    capitalMap.put("Germany", "Berlin");

    // Displaying the HashMap
    System.out.println("HashMap: " + capitalMap);

    // HashMap stores data in the form of key-value pairs
    System.out.println("\nKey-Value pairs in the HashMap:");
    for (Map.Entry<String, String> entry : capitalMap.entrySet()) {
      System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
    }

    // HashMap contains unique keys
    capitalMap.put("USA", "New York"); // Updating the value for an existing key
    capitalMap.put("Japan", "Tokyo");  // Adding a new key-value pair

    System.out.println("\nUpdated HashMap after adding a new key:");
    System.out.println("HashMap: " + capitalMap);

    // HashMap can have one key as null and multiple null values
    capitalMap.put(null, "Some Value");
    capitalMap.put("Null Key", null);
    capitalMap.put("Another Null Key", null);

    System.out.println("\nHashMap with null key and values:");
    System.out.println("HashMap: " + capitalMap);

    // HashMap does not maintain the order of elements
    System.out.println("\nOrder of elements in the HashMap:");
    for (Map.Entry<String, String> entry : capitalMap.entrySet()) {
      System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
    }
  }
}
