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

// Interface extending nested interface
interface AdvancedBird extends Bird.WaterBird {
    void dive();
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
        System.out.println("Eagle flies high");
    }
}

class Ostrich implements Bird.NonFlyingBird {
    @Override
    public void run() {
        System.out.println("Ostrich runs fast");
    }
}

class Duck implements Bird, Bird.WaterBird {

    @Override
    public void fly() {
        System.out.println("Duck flies");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

class Swan implements Bird, Bird.WaterBird, Bird.NonFlyingBird {

    @Override
    public void fly() {
        System.out.println("Swan flies");
    }

    @Override
    public void swim() {
        System.out.println("Swan swims");
    }

    @Override
    public void run() {
        System.out.println("Swan runs");
    }
}

class Penguin implements AdvancedBird {

    @Override
    public void swim() {
        System.out.println("Penguin swims");
    }

    @Override
    public void dive() {
        System.out.println("Penguin dives deep");
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

// Nested interface extending another nested interface
interface Animal {

    interface Walker {
        void walk();
    }

    interface Runner extends Walker {
        void run();
    }
}

class Horse implements Animal.Runner {

    @Override
    public void walk() {
        System.out.println("Horse walks");
    }

    @Override
    public void run() {
        System.out.println("Horse runs");
    }
}

// Functional nested interface
interface Machine {

    interface Switch {
        void turnOn();
    }
}

// Nested interface inside another nested interface
interface Vehicle {

    interface Engine {

        interface Electric {
            void charge();
        }
    }

    interface Electric {

        void charge();

        default void batteryStatus() {
            System.out.println("Battery is healthy");
        }
    }
}

class Tesla implements Vehicle.Engine.Electric {

    @Override
    public void charge() {
        System.out.println("Tesla charging");
    }
}

class EVCar implements Vehicle.Electric {

    @Override
    public void charge() {
        System.out.println("Charging EV...");
    }
}

// Static method inside nested interface
interface Shape {

    interface Calculator {

        static int square(int x) {
            return x * x;
        }
    }
}

public class NestedInterfaceDemo {

    public static void main(String[] args) {

        Parrot parrot = new Parrot();
        parrot.fly();
        parrot.info();

        Eagle eagle = new Eagle();
        eagle.fly();

        Ostrich ostrich = new Ostrich();
        ostrich.run();

        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        Swan swan = new Swan();
        swan.fly();
        swan.swim();
        swan.run();

        Penguin penguin = new Penguin();
        penguin.swim();
        penguin.dive();

        Bird.category();

        Dog dog = new Dog();
        dog.bark();

        Dog.Puppy puppy = dog.new Puppy();
        puppy.play();

        Dog.GermanShepherd guardDog = new Dog.GermanShepherd();
        guardDog.protect();

        // Anonymous class
        Bird.NonFlyingBird kiwi = new Bird.NonFlyingBird() {
            @Override
            public void run() {
                System.out.println("Kiwi runs");
            }
        };
        kiwi.run();

        // Lambda expression
        Machine.Switch sw = () -> System.out.println("Machine turned ON");
        sw.turnOn();

        Bird.NonFlyingBird emu = () -> System.out.println("Emu runs very fast");
        emu.run();

        Horse horse = new Horse();
        horse.walk();
        horse.run();

        Tesla tesla = new Tesla();
        tesla.charge();

        EVCar car = new EVCar();
        car.charge();
        car.batteryStatus();

        System.out.println("Square of 5 = " + Shape.Calculator.square(5));
    }
}