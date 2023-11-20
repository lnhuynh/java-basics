package javabasics;

public class OOP extends AbstractClass implements IOOP {

  //When a class extends an abstract class, it must override all the abstract method inside that abstract class
  @Override
  void log() {
    System.out.println("Call log method");
  }

  //When a class implements an interface, it must override all the method(without default keyword) inside that interface
  @Override
  public void log2() {}

//  This will cause an error because you can't override interface's method(public as default) with weaker privilege
//  @Override
//  void log2() {}

// Override a default method in interface is optional
//  @Override
//  public void log3() {
//    IOOP.super.log3();
//  }

}

abstract class AbstractClass {
  abstract void log();
//  void log() {}; This will cause an error because you can not declare concrete method inside abstract class
}

interface IOOP {
  void log2();
//  void log3() {}; This will cause an error because method inside interface can not have body
  default void log3() { //This won't cause an error because you can define a method with body inside interface with default keyword
    System.out.println("Call log3 method");
  }

  private void log4() { //This won't cause an error because private method must have body
    System.out.println("Call log3 method");
  }
}
