package javaadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JavaOptional {
  public static void main(String[] args) {
    // Creating an Optional with a non-null value
    Optional<String> nonNullOptional = Optional.of("Hello, World!");

    // Creating an Optional with a potentially null value
    String nullableValue = "Some value or null";
    Optional<String> nullableOptional = Optional.ofNullable(nullableValue);

    // Creating an empty Optional
    Optional<String> emptyOptional = Optional.empty();

    // Checking if a value is present
    if (nonNullOptional.isPresent()) {
      System.out.println("Non-null Optional: " + nonNullOptional.get());
    } else {
      System.out.println("Non-null Optional is empty.");
    }

    // IfPresent: Performing an action if a value is present
    nonNullOptional.ifPresent(value -> System.out.println("Value found: " + value));

    // Using orElse: Providing a default value if the Optional is empty
    String result = emptyOptional.orElse("Default Value");
    System.out.println("Result with orElse: " + result);

    // Using orElseGet: Providing a supplier for the default value
    String resultFromSupplier = emptyOptional.orElseGet(() -> "Default Value from Supplier");
    System.out.println("Result with orElseGet: " + resultFromSupplier);

    // Using map to transform the value inside the Optional
    String transformedValue = nonNullOptional.map(s -> s.toUpperCase()).orElse("No value");
    System.out.println("Transformed Value: " + transformedValue);

    // Using filter to conditionally apply a transformation
    String filteredValue = nonNullOptional.filter(s -> s.length() > 5).orElse("Too short");
    System.out.println("Filtered Value: " + filteredValue);

  }
}

class LazyInvocation {
  List<String> list = Arrays.asList("abc1", "abc2", "abc3");
  private long counter;

  private void wasCalled() {
    counter++;
  }

  // These code will not change counter property, because it doesn't have terminal operator
  Stream<String> stream1 = list.stream().filter(element -> {
    wasCalled();
    return element.contains("2");
  });

  // These code is reduce loop times of filter and map operations, because filter only being called 2 times and map 1 time with findFirst terminal operator
  Optional<String> stream2 = list.stream().filter(element -> {
    System.out.println("filter() was called");
    return element.contains("2");
  }).map(element -> {
    System.out.println("map() was called");
    return element.toUpperCase();
  }).findFirst();

  // In this example, counter will be set to 3 and size is set to 1, so map will be called twice for no reason
  long size = list.stream().map(element -> {
    wasCalled();
    return element.substring(0, 3);
  }).skip(2).count();

  // Above example can be fixed like this
  // Intermediate operations which reduce the size of the stream should be placed before operations which are applying to each element.
  // So we need to keep methods such as skip(), filter(), and distinct() at the top of our stream pipeline
  long size2 = list.stream().skip(2).map(element -> {
    wasCalled();
    return element.substring(0, 3);
  }).count();
}
