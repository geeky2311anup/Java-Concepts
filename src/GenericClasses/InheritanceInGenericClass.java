
import java.util.*;

// Generic parent class
// T acts as a placeholder for the actual data type
class Print<T> {

    T value;

    public Print(T value) {
        this.value = value;
    }

    // Displays the value stored in the generic variable
    public void display() {
        System.out.println("Value: " + value);
    }
}


// Generic child class inheriting the parent class
// Both parent and child use the same generic type T
class ColorPrint<T> extends Print<T> {

    T childValue;

    public ColorPrint(T value, T childValue) {
        super(value);  // Initialize the parent class variable
        this.childValue = childValue;
    }

    // Method overriding: Child provides its own implementation
    @Override
    public void display() {
        System.out.println("Parent Value: " + value);
    }

    // Displays data from both parent and child classes
    public void displayChild() {
        System.out.println("Parent value is: " + value);
        System.out.println("Child value is: " + childValue);
    }
}


// Another generic child class
class NumberPrint<T> extends Print<T> {

    public NumberPrint(T value) {
        super(value);
    }

    // Demonstrates runtime type checking using instanceof
    public void squareIfNumber() {

        if (value instanceof Integer) {
            Integer num = (Integer) value;
            System.out.println("Square = " + (num * num));

        } else if (value instanceof Double) {
            Double num = (Double) value;
            System.out.println("Square = " + (num * num));

        } else {
            System.out.println("Not a numeric type.");
        }
    }
}


// Utility class containing generic methods
class GenericUtils {

    // Generic method: Same method works with different data types
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    // Generic method with a return type T
    public static <T> T getValue(T value) {
        return value;
    }
}


// Main class
public class InterfaceInGenericClass {

    public static void main(String[] args) {

        // Generic class with String type
        Print<String> obj1 =
                new Print<>("This is String value from parent class");

        obj1.display();

        System.out.println();


        // Generic inheritance with String type
        ColorPrint<String> childobj1 =
                new ColorPrint<>("Parent String", "Child String");

        childobj1.display();
        childobj1.displayChild();

        System.out.println();


        // Generic class with Integer type
        Print<Integer> obj2 = new Print<>(100);

        obj2.display();

        System.out.println();


        // Generic child class with Integer type
        ColorPrint<Integer> childobj2 =
                new ColorPrint<>(200, 300);

        childobj2.displayChild();

        System.out.println();


        // NumberPrint with Integer
        NumberPrint<Integer> num1 = new NumberPrint<>(12);

        num1.display();
        num1.squareIfNumber();

        System.out.println();


        // NumberPrint with Double
        NumberPrint<Double> num2 = new NumberPrint<>(7.5);

        num2.display();
        num2.squareIfNumber();

        System.out.println();


        // Generic method with String
        GenericUtils.printTwice("Hello Generics");

        System.out.println();


        // Generic method returning Integer
        int value = GenericUtils.getValue(500);
        System.out.println("Returned value = " + value);

        // Generic method returning String
        String name = GenericUtils.getValue("Java");
        System.out.println("Returned String = " + name);


        // Same generic method can accept different wrapper types
        Double decimal = GenericUtils.getValue(25.5);
        System.out.println("Returned Double = " + decimal);
    }
}
