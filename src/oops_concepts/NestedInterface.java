interface Bird {

    void fly();

    interface NonFlyingBird {
        void run();
    }

    interface WaterBird {
        void swim();
    }

    interface Predator {
        void hunt();
    }

    default void info() {
        System.out.println("This is a bird.");
    }

    static void category() {
        System.out.println("Birds belong to Aves.");
    }
}

interface AdvancedBird extends Bird.WaterBird {
    void dive();
}

class Parrot implements Bird {

    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }
}

class Eagle implements Bird, Bird.Predator {

    @Override
    public void fly() {
        System.out.println("Eagle flies high");
    }

    @Override
    public void hunt() {
        System.out.println("Eagle hunts from the sky");
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

interface Machine {

    interface Switch {
        void turnOn();
    }

    interface Control {
        void start();
        void stop();
    }
}

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

interface Shape {

    interface Calculator {

        static int square(int x) {
            return x * x;
        }

        static int cube(int x) {
            return x * x * x;
        }
    }
}

// Multiple levels of nested interfaces
interface Computer {

    interface Hardware {

        interface Processor {
            void process();
        }
    }

    interface Software {
        void run();
    }
}

class IntelProcessor implements Computer.Hardware.Processor {

    @Override
    public void process() {
        System.out.println("Intel processor is processing");
    }
}

class OperatingSystem implements Computer.Software {

    @Override
    public void run() {
        System.out.println("Operating system is running");
    }
}

// Interface containing another interface with default method
interface Mobile {

    interface Camera {

        void capture();

        default void quality() {
            System.out.println("Camera quality: High");
        }
    }
}

class Phone implements Mobile.Camera {

    @Override
    public void capture() {
        System.out.println("Phone captures a photo");
    }
}

// Nested interface with constants
interface Bank {

    interface Account {

        double MIN_BALANCE = 1000.0;

        void deposit(double amount);

        void withdraw(double amount);
    }
}

class SavingsAccount implements Bank.Account {

    private double balance = Bank.Account.MIN_BALANCE;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= Bank.Account.MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Minimum balance requirement not satisfied");
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
        eagle.hunt();

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

        Bird.NonFlyingBird kiwi = new Bird.NonFlyingBird() {
            @Override
            public void run() {
                System.out.println("Kiwi runs");
            }
        };

        kiwi.run();

        Machine.Switch machineSwitch =
                () -> System.out.println("Machine turned ON");

        machineSwitch.turnOn();

        Machine.Control control = new Machine.Control() {

            @Override
            public void start() {
                System.out.println("Machine started");
            }

            @Override
            public void stop() {
                System.out.println("Machine stopped");
            }
        };

        control.start();
        control.stop();

        Bird.NonFlyingBird emu =
                () -> System.out.println("Emu runs very fast");

        emu.run();

        Horse horse = new Horse();
        horse.walk();
        horse.run();

        Tesla tesla = new Tesla();
        tesla.charge();

        EVCar car = new EVCar();
        car.charge();
        car.batteryStatus();

        System.out.println("Square of 5 = "
                + Shape.Calculator.square(5));

        System.out.println("Cube of 3 = "
                + Shape.Calculator.cube(3));

        IntelProcessor processor = new IntelProcessor();
        processor.process();

        OperatingSystem os = new OperatingSystem();
        os.run();

        Phone phone = new Phone();
        phone.capture();
        phone.quality();

        SavingsAccount account = new SavingsAccount();
        account.deposit(5000);
        account.withdraw(2000);
    }
}
