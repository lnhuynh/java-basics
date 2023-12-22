package javaadvanced.designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface Shape {
  Shape createShape();
  void draw();
}

class Circle implements Shape {
  @Override
  public Shape createShape() {
    System.out.println("Creating Circle");
    return new Circle();
  }

  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }
}

class Square implements Shape {
  @Override
  public Shape createShape() {
    System.out.println("Creating Square");
    return new Square();
  }
  @Override
  public void draw() {
    System.out.println("Drawing Square");
  }
}

class Triangle implements Shape {
  @Override
  public Shape createShape() {
    System.out.println("Creating Triangle");
    return new Triangle();
  }
  @Override
  public void draw() {
    System.out.println("Drawing Triangle");
  }
}

class ShapeFactory {
  private final Map<String, Supplier<Shape>> factoryRegistry = new HashMap<>();

  void setFactoryRegistry(String type, Supplier<Shape> shape) {
    factoryRegistry.put(type, shape);
  }

  Shape getFactoryRegistry(String type) {
    Supplier<Shape> shapeSupplier = factoryRegistry.get(type);
    if (shapeSupplier == null) {
      throw new IllegalArgumentException("Unknown shape type: " + type);
    }
    return shapeSupplier.get();
  }
}

public class FactoryMethod {
  public final static String CIRCLE = "CIRCLE";
  public final static String SQUARE = "SQUARE";
  public final static String TRIANGLE = "TRIANGLE";
  public static void main(String[] args) {
    ShapeFactory shapeFactory = new ShapeFactory();

    // Create different shapes
    shapeFactory.setFactoryRegistry(CIRCLE, Circle::new);
    shapeFactory.setFactoryRegistry(SQUARE, Square::new);
    shapeFactory.setFactoryRegistry(TRIANGLE, Triangle::new);

    // Draw shapes
    shapeFactory.getFactoryRegistry(CIRCLE).draw();
    shapeFactory.getFactoryRegistry(SQUARE).draw();
    shapeFactory.getFactoryRegistry(TRIANGLE).draw();
  }
}
