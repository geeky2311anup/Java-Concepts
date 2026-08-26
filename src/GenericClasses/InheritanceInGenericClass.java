// Generic parent class
class Print<T> {

    // Generic variable that can store any data type
    T value;

    // Constructor to initialize the value
    public Print(T value) {
        this.value = value;
    }

    // Method to display the stored value
    public void display() {
        System.out.println("Value: " + value);
    }
}


// Generic child class that inherits from Print<T>
class ColorPrint<T> extends Print<T> {

    // Additional variable for the child class
    T childValue;

    // Constructor initializes both parent and child values
    public ColorPrint(T value, T childValue) {
        super(value);              // Calls the parent class constructor
        this.childValue = childValue;
    }

    // Overriding the display() method of the parent class
    @Override
    public void display() {
        System.out.println("Parent Value: " + value);
    }

    // Displays both parent and child values
    public void displayChild() {
        System.out.println("Parent value is: " + value);
        System.out.println("Child value is: " + childValue);
    }
}


// Another generic child class extending Print<T>
class NumberPrint<T> extends Print<T> {

    // Constructor for NumberPrint
    public NumberPrint(T value) {
        super(value);
    }

    // Checks whether the generic value is Integer or Double
    // and calculates its square
    public void squareIfNumber() {

        // Check if the value is an Integer
        if (value instanceof Integer) {

            Integer num = (Integer) value;
            System.out.println("Square = " + (num * num));

        // Check if the value is a Double
        } else if (value instanceof Double) {

            Double num = (Double) value;
            System.out.println("Square = " + (num * num));

        // If the value is neither Integer nor Double
        } else {
            System.out.println("Not a numeric type.");
        }
    }
}


// Utility class containing generic methods
class GenericUtils {

    // Generic method that prints the same value twice
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    // Generic method that returns the value passed to it
    public static <T> T getValue(T value) {
        return value;
    }
}


// Main class
public class InterfaceInGenericClass {

    public static void main(String[] args) {

        // --------------------------------------------------
        // Parent class using String as the generic type
        // --------------------------------------------------

        Print<String> obj1 =
                new Print<>("This is String value from parent class");

        // Calls the parent class display() method
        obj1.display();

        System.out.println();


        // --------------------------------------------------
        // Child class using String as the generic type
        // --------------------------------------------------

        ColorPrint<String> childobj1 =
                new ColorPrint<>("Parent String", "Child String");

        // Calls the overridden display() method
        childobj1.display();

        // Displays both parent and child values
        childobj1.displayChild();

        System.out.println();


        // --------------------------------------------------
        // Parent class using Integer as the generic type
        // --------------------------------------------------

        Print<Integer> obj2 = new Print<>(100);

        // Displays the Integer value
        obj2.display();

        System.out.println();


        // --------------------------------------------------
        // Child class using Integer as the generic type
        // --------------------------------------------------

        ColorPrint<Integer> childobj2 =
                new ColorPrint<>(200, 300);

        // Displays both Integer values
        childobj2.displayChild();

        System.out.println();


        // --------------------------------------------------
        // NumberPrint using Integer
        // --------------------------------------------------

        NumberPrint<Integer> num1 = new NumberPrint<>(12);

        // Inherited display() method
        num1.display();

        // Calculates and displays the square
        num1.squareIfNumber();

        System.out.println();


        // --------------------------------------------------
        // NumberPrint using Double
        // --------------------------------------------------

        NumberPrint<Double> num2 = new NumberPrint<>(7.5);

        // Inherited display() method
        num2.display();

        // Calculates and displays the square
        num2.squareIfNumber();

        System.out.println();


        // --------------------------------------------------
        // Using the generic printTwice() method
        // --------------------------------------------------

        GenericUtils.printTwice("Hello Generics");

        System.out.println();


        // --------------------------------------------------
        // Using the generic getValue() method with Integer
        // --------------------------------------------------

        int value = GenericUtils.getValue(500);
        System.out.println("Returned value = " + value);


        // --------------------------------------------------
        // Using the generic getValue() method with String
        // --------------------------------------------------

        String name = GenericUtils.getValue("Java");
        System.out.println("Returned String = " + name);
    }
}
