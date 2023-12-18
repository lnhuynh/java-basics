package javaadvanced.designpattern;

interface Shape {
  void draw();
}

class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }
}

class Square implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Square");
  }
}

class Triangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Triangle");
  }
}

class ShapeFactory {
  public Shape createShape(String shapeType) {
    if (shapeType == null) {
      return null;
    }

    if (shapeType.equalsIgnoreCase("CIRCLE")) {
      return new Circle();
    }
    if (shapeType.equalsIgnoreCase("SQUARE")) {
      return new Square();
    }
    if (shapeType.equalsIgnoreCase("TRIANGLE")) {
      return new Triangle();
    }

    return null;
  }
}

public class FactoryMethod {
  public static void main(String[] args) {
    ShapeFactory shapeFactory = new ShapeFactory();

    // Create different shapes
    Shape circle = shapeFactory.createShape("CIRCLE");
    Shape square = shapeFactory.createShape("SQUARE");
    Shape triangle = shapeFactory.createShape("TRIANGLE");

    // Draw shapes
    circle.draw();
    square.draw();
    triangle.draw();
  }
}
