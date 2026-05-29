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

public class NestedInterfaceDemo {

    public static void main(String[] args) {

        // Nested interface implementation
        Parrot p = new Parrot();
        p.fly();
        p.info();

        Ostrich o = new Ostrich();
        o.run();

        Duck d = new Duck();
        d.fly();
        d.swim();

        // Static interface method
        Bird.category();

        // Inner class implementing private interface
        Dog dog = new Dog();
        dog.bark();

        Dog.Puppy puppy = dog.new Puppy();
        puppy.play();

        // Static nested class implementing nested interface
        Dog.GermanShepherd gs = new Dog.GermanShepherd();
        gs.protect();

        // Anonymous implementation of nested interface
        Bird.NonFlyingBird penguin = new Bird.NonFlyingBird() {
            @Override
            public void run() {
                System.out.println("Penguin waddles and runs");
            }
        };

        penguin.run();
    }
}
