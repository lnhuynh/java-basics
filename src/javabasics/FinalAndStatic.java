package javabasics;

public class FinalAndStatic {
  static final int MAX_NUMBER = 10000;
  int nonStaticProperty = 10;

  final void log() {
    System.out.println("Call log method");
  }

  static void log2() {
//    System.out.println(nonStaticProperty); This will cause an error because you can not access non-static field in static method
    System.out.println("Call log2 method");
  }

  public static void main(String[] args) {
//    MAX_NUMBER = 0; This will cause an error because you can't reassign final property
  }
}

class ExampleClass extends  FinalAndStatic {
  // This will cause an error because you can't override final method
//  @Override
//  void log() {
//    System.out.println("Child class call log method");
//  }

  void logStatic() {
    FinalAndStatic.log2(); // This won't cause an error because static method can be accessed through class, not only object
    System.out.println(FinalAndStatic.MAX_NUMBER); // This won't cause an error because static property can be accessed through class, not only object
  }
}
