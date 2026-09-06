class GenericMethodDemo {

    public <T> void display(T value) {
        System.out.println(value);
    }
}

class Animal {
    public String type;
    public String note = "this is public data member";

    public Animal(String type) {
        this.type = type;
    }
}

public class GenericMethod {
    public static void main(String[] args) {

        Animal obj = new Animal("carnivore");

        System.out.println(obj.type);
        // 1st Output: carnivore

        GenericMethodDemo obj2 = new GenericMethodDemo();

        obj2.display(obj);
        // 2nd Output: Animal@6d06d69c
    }
}

/*
 * ============================
 * GENERIC METHOD NOTES
 * ============================
 *
 * 1. What does <T> mean?
 *
 * <T> declares a generic type parameter for the method.
 *
 * public <T> void display(T value)
 *
 * Here:
 *      T       -> type parameter
 *      value   -> variable of type T
 *
 * T can represent different types depending on what we pass.
 *
 * Example:
 *
 * display(10);          -> T becomes Integer
 * display("Hello");     -> T becomes String
 * display(5.5);          -> T becomes Double
 * display(obj);          -> T becomes Animal
 *
 *
 * 2. Java automatically determines T
 *
 * When we write:
 *
 * obj2.display(obj);
 *
 * Java sees that obj is an Animal object.
 * Therefore, for this particular call:
 *
 * T = Animal
 *
 * So conceptually, it becomes:
 *
 * void display(Animal value)
 *
 * We don't have to explicitly specify Animal.
 *
 *
 * 3. What happens inside display()?
 *
 * System.out.println(value);
 *
 * println() receives an object/reference.
 *
 * Java effectively calls:
 *
 * value.toString()
 *
 *
 * 4. Why do we get Animal@6d06d69c?
 *
 * Animal does NOT override toString().
 *
 * Therefore, Animal inherits toString() from Object.
 *
 * Object.toString() produces a string in this general form:
 *
 * ClassName@HashCodeInHex
 *
 * Therefore:
 *
 * Animal@6d06d69c
 *   |       |
 *   |       +--> hexadecimal hash code
 *   |
 *   +----------> class name
 *
 * IMPORTANT:
 *
 * 6d06d69c is NOT necessarily the object's actual memory address.
 * It is related to the object's hashCode() representation.
 *
 *
 * 5. If we override toString()
 *
 * Add this inside Animal:
 *
 * @Override
 * public String toString() {
 *     return "Animal{type='" + type + "', note='" + note + "'}";
 * }
 *
 * Now:
 *
 * obj2.display(obj);
 *
 * will print:
 *
 * Animal{type='carnivore', note='this is public data member'}
 *
 *
 * 6. Why is toString() called automatically?
 *
 * println() needs a String representation of the object.
 *
 * So when we write:
 *
 * System.out.println(obj);
 *
 * Java internally behaves approximately like:
 *
 * System.out.println(obj.toString());
 *
 *
 * 7. Generic method can accept different types
 *
 * GenericMethodDemo demo = new GenericMethodDemo();
 *
 * demo.display(100);
 * demo.display("Java");
 * demo.display(25.5);
 * demo.display(obj);
 *
 * All of these calls can use the SAME display() method.
 *
 *
 * 8. Generic methods are different from method overloading
 *
 * We don't need:
 *
 * void display(Integer x)
 * void display(String x)
 * void display(Animal x)
 *
 * Instead, one generic method is enough:
 *
 * <T> void display(T value)
 *
 *
 * 9. T is NOT a specific class
 *
 * T is just a placeholder for a type.
 *
 * It could represent:
 *
 * Integer
 * String
 * Animal
 * Double
 * etc.
 *
 *
 * ============================
 * IMPORTANT CONCEPT
 * ============================
 *
 * Generic method:
 *
 * public <T> void display(T value)
 *
 * means:
 *
 * "This method can work with a value of any type,
 * and Java will determine that type when the method
 * is called."
 *
 */
