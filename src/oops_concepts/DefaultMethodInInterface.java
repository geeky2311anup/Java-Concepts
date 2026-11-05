
interface Bird {

    // Abstract method: Every implementing class must define it
    public void fly();

    // Default method: Provides a common implementation
    default void eat() {
        System.out.println("Bird is eating");
    }
}

// Hen inherits all methods of Bird and overrides its default method
interface Hen extends Bird {

    @Override
    default void eat() {
        System.out.println("Hen is eating grains");
    }
}

// Chicken implements Hen
class chicken implements Hen {

    @Override
    public void fly() {
        System.out.println("Chicken can fly");
    }

    // No need to override eat(), Hen already provides its implementation
}

// Parrot directly implements Bird
class parrot implements Bird {

    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }

    // Uses the default eat() method from Bird
}

public class DefaultMethodInInterface {

    public static void main(String[] args) {

        // Parrot uses Bird's default implementation of eat()
        parrot p = new parrot();

        p.fly();
        p.eat();

        System.out.println("------------------");

        // Chicken inherits the overridden default method from Hen
        chicken c = new chicken();

        c.fly();
        c.eat();
    }
}
