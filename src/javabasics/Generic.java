package javabasics;

class Box<T> {
  private T item;

  public Box(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public void printInfo() {
    System.out.println("Box contains: " + item);
  }

}

public class Generic {
  public static void main(String[] args) {
    Box<String> stringBox = new Box<>("Item String");

    String itemInStringBox = stringBox.getItem();
    System.out.println("Item in String Box: " + itemInStringBox);

    stringBox.printInfo();

    Box<Integer> intBox = new Box<>(10);

    Integer itemInIntBox = intBox.getItem();
    System.out.println("Item in Integer Box: " + itemInIntBox);

    intBox.printInfo();
  }
}
