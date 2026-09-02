interface Bird {

    // Variables inside an interface are automatically:
    // public static final
    int weight = 5;

    // Explicitly public static final
    public static final String color = "varied";

    // Abstract method -> implementing class must provide it
    public void fly();

    // Default method -> implementing class does NOT have to override it
    default void eat() {
        System.out.println("Bird can eat");
    }

    // Static method -> belongs to the interface, not the object
    static void birdInfo() {
        System.out.println("Bird is a living creature");
    }
}

interface LivingThings {

    public void canBreathe();

    default void live() {
        System.out.println("Living thing can live");
    }
}

// An interface can extend multiple interfaces
interface NonFlyingBird extends Bird, LivingThings {

    public void canRun();
}

class Hen implements NonFlyingBird {

    @Override
    public void fly() {
        System.out.println("It can fly in limit");
    }

    @Override
    public void canBreathe() {
        System.out.println("It can breathe");
    }

    @Override
    public void canRun() {
        System.out.println("It can run");
    }
}

public class Interface_in_deep {

    public static void main(String[] args) {

        // Object reference = Hen
        Hen hen = new Hen();

        hen.fly();
        hen.canBreathe();
        hen.canRun();

        // Default methods are inherited automatically
        hen.eat();
        hen.live();

        // Interface variables are constants
        System.out.println("Weight: " + Bird.weight);
        System.out.println("Color: " + Bird.color);

        // Static interface method
        Bird.birdInfo();


        // ------------------------------------------------
        // Reference type = Bird
        // Actual object = Hen
        // ------------------------------------------------

        Bird chicken = new Hen();

        chicken.fly();
        chicken.eat();

        // ERROR:
        // chicken.canBreathe();

        // Why?
        // Because reference type is Bird.
        // Bird does not contain canBreathe().


        // ------------------------------------------------
        // Reference type = LivingThings
        // Actual object = Hen
        // ------------------------------------------------

        LivingThings livingThing = new Hen();

        livingThing.canBreathe();
        livingThing.live();

        // ERROR:
        // livingThing.fly();

        // Why?
        // Reference type is LivingThings.
        // LivingThings does not contain fly().


        // ------------------------------------------------
        // Reference type = NonFlyingBird
        // Actual object = Hen
        // ------------------------------------------------

        NonFlyingBird bird = new Hen();

        bird.fly();
        bird.canBreathe();
        bird.canRun();
    }
}
