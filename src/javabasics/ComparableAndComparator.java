package javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {
  static class Human implements Comparable<Human> {
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

    @Override
    public int compareTo(Human human) {
      return Integer.compare(this.getAge(), human.getAge());
    }
  }

  public static void main(String[] args) {
    List<Human> humanList = new ArrayList<>();
    humanList.add(new Human("Huynh", 23));
    humanList.add(new Human("Khoa", 10));
    humanList.add(new Human("Cuong", 21));

    System.out.println("Before using Comparable");
    for (Human human : humanList) {
      System.out.println(human.toString());
    }
    Collections.sort(humanList);
    System.out.println("After using Comparable");
    for (Human human : humanList) {
      System.out.println(human.toString());
    }

//    Comparator<Human> humanComparator = Comparator.comparing(Human::getAge);
//    System.out.println("Before using Comparator");
//    for (Human human : humanList) {
//      System.out.println(human.toString());
//    }
//    Collections.sort(humanList, humanComparator);
//    System.out.println("After using Comparator");
//    for (Human human : humanList) {
//      System.out.println(human.toString());
//    }
  }
}
