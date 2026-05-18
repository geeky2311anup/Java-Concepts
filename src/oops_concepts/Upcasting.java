// Parent class
class Animal {

    // Method of parent class
    void sound() {
        System.out.println("Animal makes a sound");
    }

    // Another method of parent class
    void bark() {
        System.out.println("Animal barks");
    }
}

// Child class inheriting Animal
class Dog extends Animal {

    // Method overriding
    @Override
    void sound() {
        System.out.println("Dog makes sound");
    }

    // Method only available in Dog class
    void run() {
        System.out.println("Dog runs fast");
    }
}

public class Upcasting {

    public static void main(String[] args) {

        // Upcasting:
        // Parent class reference holding Child class object
        Animal puppy = new Dog();

        // Normal object creation using child class reference
        Dog puppy2 = new Dog();

        // Calls overridden method from Dog class
        // Runtime polymorphism
        puppy.sound();

        // Calls method from Animal class
        puppy.bark();

        // ERROR:
        // Parent reference cannot access child-specific methods
        // puppy.run();

        // Child reference can access all child methods
        puppy2.run();
    }
}
