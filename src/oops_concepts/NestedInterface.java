interface Bird {

    void fly();

    interface NonFlyingBird {
        void run();
    }

    interface WaterBird {
        void swim();
    }

    default void info() {
        System.out.println("This is a bird.");
    }

    static void category() {
        System.out.println("Birds belong to Aves.");
    }
}

class Dog {

    public void bark() {
        System.out.println("Dog barks");
    }

    private interface Pet {
        void play();
    }

    static interface GuardDog {
        void protect();
    }

    class Puppy implements Pet {
        @Override
        public void play() {
            System.out.println("Puppy plays");
        }
    }

    static class GermanShepherd implements GuardDog {
        @Override
        public void protect() {
            System.out.println("German Shepherd protects the house");
        }
    }
}

class Parrot implements Bird {
    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }
}

class Eagle implements Bird {
    @Override
    public void fly() {
        System.out.println("Eagle flies at high altitude");
    }
}

class Ostrich implements Bird.NonFlyingBird {
    @Override
    public void run() {
        System.out.println("Ostrich can run");
    }
}

class Duck implements Bird, Bird.WaterBird {

    @Override
    public void fly() {
        System.out.println("Duck can fly");
    }

    @Override
    public void swim() {
        System.out.println("Duck can swim");
    }
}

class Swan implements Bird.WaterBird {
    @Override
    public void swim() {
        System.out.println("Swan swims gracefully");
    }
}

public class NestedInterfaceDemo {

    public static void main(String[] args) {

        // Parrot
        Parrot p = new Parrot();
        p.fly();
        p.info();

        // Ostrich
        Ostrich o = new Ostrich();
        o.run();

        // Duck
        Duck d = new Duck();
        d.fly();
        d.swim();

        // Static interface method
        Bird.category();

        // Dog examples
        Dog dog = new Dog();
        dog.bark();

        Dog.Puppy puppy = dog.new Puppy();
        puppy.play();

        Dog.GermanShepherd gs = new Dog.GermanShepherd();
        gs.protect();

        // Interface reference
        Bird bird = new Eagle();
        bird.fly();
        bird.info();

        // WaterBird reference
        Bird.WaterBird swan = new Swan();
        swan.swim();

        // Anonymous implementation
        Bird.NonFlyingBird penguin = new Bird.NonFlyingBird() {
            @Override
            public void run() {
                System.out.println("Penguin waddles and runs");
            }
        };
        penguin.run();

        // Anonymous Bird implementation
        Bird sparrow = new Bird() {
            @Override
            public void fly() {
                System.out.println("Sparrow flies quickly");
            }
        };
        sparrow.fly();
        sparrow.info();

        // Lambda expression (functional interface)
        Bird.NonFlyingBird emu = () -> System.out.println("Emu runs very fast");
        emu.run();

        // Interface reference to static nested class
        Dog.GuardDog guard = new Dog.GermanShepherd();
        guard.protect();
    }
}
