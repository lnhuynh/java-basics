package javabasics;


class Human {
  String name;
  int age;

  @Override
  public String toString() {
    return "Human{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

public class PassByValue {
  static void plus (int a) {
    a++;
  }

  static void change(Human human) {
    human = new Human("Khoa", 23);
  }

  static void changeName(Human human) {
    human.setName("Khoa");
  }

  public static void main(String[] args) {
    int a = 10;
    Human human = new Human("Huynh", 23);

    System.out.println("Before plus " + a);
    plus(a);
    System.out.println("After plus " + a); //This will be 10 because in java we just have pass by value

    System.out.println("Before change " + human);
    change(human);
    System.out.println("After change " + human); //This will be the same human because in java we just have pass by value

    System.out.println("Before changeName " + human);
    changeName(human);
    System.out.println("After changeName " + human); //This will be human with the name is "Khoa" because when we change the name of that human object, we change it in heap memory, and when the method has executed, object's address is clear but not affect to the value in heap memory
  }
}
