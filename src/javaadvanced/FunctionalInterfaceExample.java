package javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

//A functional interface is an interface that contains only one abstract method
@FunctionalInterface // This annotation is optional
interface MyFunctionalInterface {
  void myMethod();
//  Below abstract method will cause an error
//  void mySecondMethod();
}

public class FunctionalInterfaceExample {
  public static void main(String[] args) {
    // Built-in functional interface example

    //Consumer
    List<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");

    Consumer<String> printConsumer = System.out::println;
    names.forEach(printConsumer);

    //Predicate
    Predicate<Integer> isEven = num -> num % 2 == 0;

    System.out.println(isEven.test(5));  // Output: false
    System.out.println(isEven.test(10)); // Output: true

    //Function
    Function<String, Integer> stringLength = String::length;
    System.out.println(stringLength.apply("Hello")); // Output: 5

    //Supplier
    Supplier<Double> randomSupplier = Math::random;
    System.out.println(randomSupplier.get()); // Output: a random double value

    //Variants of built-in functional interface

    //BiConsumer
    BiConsumer<String, Integer> printTwoArgs = (s, num) -> System.out.println(s + ": " + num);
    printTwoArgs.accept("Value", 42);

    //BiPredicate
    BiPredicate<Integer, Integer> areEqual = (integer, obj) -> integer.equals(obj);
    System.out.println(areEqual.test(5, 5));   // Output: true
    System.out.println(areEqual.test(10, 20)); // Output: false

    //BiFunction
    BiFunction<String, String, String> concatenateStrings = (s1, s2) -> s1 + s2;
    System.out.println(concatenateStrings.apply("Hello", "World")); // Output: HelloWorld

    //UnaryOperator
    UnaryOperator<Integer> square = num -> num * num;
    System.out.println(square.apply(5)); // Output: 25

    //BinaryOperator
    BinaryOperator<Integer> findMax = Integer::max;
    System.out.println(findMax.apply(8, 12)); // Output: 12
  }
}
