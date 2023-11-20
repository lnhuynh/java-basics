package javabasics.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
  public static void main(String[] args) {
    Hashtable<String, String> capitalHashtable = new Hashtable<>();

    capitalHashtable.put("USA", "Washington, D.C.");
    capitalHashtable.put("India", "New Delhi");
    capitalHashtable.put("France", "Paris");
    capitalHashtable.put("Germany", "Berlin");

    System.out.println("Hashtable: " + capitalHashtable);

    // Hashtable stores data in the form of key-value pairs
    System.out.println("\nKey-Value pairs in the Hashtable:");
    for (Map.Entry<String, String> entry : capitalHashtable.entrySet()) {
      System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
    }

    // Hashtable contains unique keys
    // Attempting to add a duplicate key will replace the existing value
    capitalHashtable.put("USA", "New York");

    System.out.println("\nUpdated Hashtable after adding a new key:");
    System.out.println("Hashtable: " + capitalHashtable);

    // Hashtable does not allow any key or value to be null
    // Uncommenting the next two lines will result in a NullPointerException
    // capitalHashtable.put(null, "Some Value");
    // capitalHashtable.put("Null Key", null);
  }
}
