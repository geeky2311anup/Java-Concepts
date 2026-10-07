// Generic parent class
class Print<T> {

    T value;

    // Constructor of the generic class
    public Print(T value) {
        this.value = value;
    }

    // Displays the stored value
    public void display() {
        System.out.println("Value: " + value);
    }
}

// Non-generic child class extending Print<String>
class ColorPrint extends Print<String> {

    public String color;

    // Child class constructor
    public ColorPrint(String value, String color) {

        // Calls the parent constructor and initializes value
        super(value);

        // Initializes the child class variable
        this.color = color;
    }

    // Displays both value and color
    public void displayColor() {
        System.out.println("Value: " + value + ", Color: " + color);
    }
}

public class InheritanceInNonGenericSubclass {

    public static void main(String[] args) {

        // Creates a ColorPrint object with String values
        ColorPrint cp = new ColorPrint("Hello", "Red");

        // Method inherited from the generic parent class
        cp.display();

        // Method defined in the child class
        cp.displayColor();
    }
}
