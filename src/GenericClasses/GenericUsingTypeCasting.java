
// A class that can store values of any data type using Object
class Print {
    Object value; // Object is the parent class of all Java classes

    // Getter method to return the stored value
    public Object getValue() {
        return value;
    }

    // Constructor to initialize the value
    public Print(Object value) {
        this.value = value;
    }
}

public class GenericUsingTypeCasting {
    public static void main(String[] args) {

        // Creating objects with different data types
        Print p1 = new Print(100);
        Print p2 = new Print("Hello World");
        Print p3 = new Print(45.67);
        Print p4 = new Print(true);

        // Retrieving values requires explicit type casting
        // because getValue() returns an Object

        int num = (Integer) p1.getValue();
        String str = (String) p2.getValue();
        double decimal = (Double) p3.getValue();
        boolean flag = (Boolean) p4.getValue();

        // Displaying the retrieved values
        System.out.println("Integer Value : " + num);
        System.out.println("String Value  : " + str);
        System.out.println("Double Value  : " + decimal);
        System.out.println("Boolean Value : " + flag);
    }
}
