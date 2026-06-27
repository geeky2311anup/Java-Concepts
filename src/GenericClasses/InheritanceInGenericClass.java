class Print<T> {
    T value;

    public Print(T value) {
        this.value = value;
    }

    public void display() {
        System.out.println("Value: " + value);
    }
}

class ColorPrint<T> extends Print<T> {
    T childValue;

    public ColorPrint(T value, T childValue) {
        super(value);
        this.childValue = childValue;
    }

    @Override
    public void display() {
        System.out.println("Parent Value: " + value);
    }

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

// Generic utility class
class GenericUtils {

    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    public static <T> T getValue(T value) {
        return value;
    }
}

public class InterfaceInGenericClass {

    public static void main(String[] args) {

        // Parent class with String
        Print<String> obj1 =
                new Print<>("This is String value from parent class");
        obj1.display();

        System.out.println();

        // Child class with String
        ColorPrint<String> childobj1 =
                new ColorPrint<>("Parent String", "Child String");

        childobj1.display();
        childobj1.displayChild();

        System.out.println();

        // Parent class with Integer
        Print<Integer> obj2 = new Print<>(100);
        obj2.display();

        System.out.println();

        // Child class with Integer
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

        // Generic utility methods
        GenericUtils.printTwice("Hello Generics");

        System.out.println();

        int value = GenericUtils.getValue(500);
        System.out.println("Returned value = " + value);

        String name = GenericUtils.getValue("Java");
        System.out.println("Returned String = " + name);
    }
}
