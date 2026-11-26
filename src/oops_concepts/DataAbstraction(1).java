
// Abstract class defining a common structure for all shapes
abstract class Shape {

    // Abstract method that must be implemented by subclasses
    public abstract double area();

    // Concrete method to display the calculated area
    public void displayArea() {
        System.out.println("Area is: " + area());
    }
}

// Circle class inheriting the Shape class
class Circle extends Shape {

    private double radius;

    // Constructor to initialize circle radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing the abstract area() method
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class inheriting the Shape class
class Rectangle extends Shape {

    private double length;
    private double breadth;

    // Constructor to initialize rectangle dimensions
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Calculating the area of rectangle
    @Override
    public double area() {
        return length * breadth;
    }
}

// Main class to demonstrate data abstraction
public class DataAbstraction {

    public static void main(String[] args) {

        // Creating a Circle object
        Circle objCircle = new Circle(6);
        objCircle.displayArea();

        // Creating a Rectangle object
        Rectangle objRectangle = new Rectangle(4, 5);
        objRectangle.displayArea();
    }
}
