package javaadvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface MyFuncInterface {
  void myMethod(String s);
}


interface MyFuncInterface2 {
  void myMethod();
}
interface MyFunctionalInterface3 {
  MyClass create(String s);
}

class MyClass {

  MyClass(String s) {
    System.out.println("Object created with value: " + s);
  }


  static void staticMethod(String s) {
    System.out.println(s);
  }

  void instanceMethod() {
    System.out.println("Instance method called: ");
  }
}

public class MethodReference {
  public static void main(String[] args) {
//    Static Method Reference
    MyFuncInterface reference1 = MyClass::staticMethod; // s -> MyClass.staticMethod(s)
    reference1.myMethod("Hello, World!");

//    Instance Method Reference on a Particular Instance
    MyClass obj = new MyClass("abc");
    MyFuncInterface2 reference = obj::instanceMethod; // () -> obj.instanceMethod()
    reference.myMethod();

//    Instance Method Reference on an Arbitrary Instance of a Particular Type
    List<String> personList = new ArrayList<>();
    personList.add("Huynh");
    personList.add("Khoa");
    personList.add("Cuong");

    personList.sort(String::compareToIgnoreCase); // (s, str) -> s.compareToIgnoreCase(str)

//    Constructor Reference
    MyFunctionalInterface3 reference4 = MyClass::new; // s -> new MyClass(s)
    reference4.create("Hello");
  }
}
