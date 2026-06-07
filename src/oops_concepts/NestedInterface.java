Your example already covers:

Nested interfaces inside interfaces
Nested interfaces inside classes
Private nested interfaces
Static nested interfaces
Default methods
Static methods
Anonymous class implementations

Here are a few more advanced things you can add.

1. Interface extending a nested interface
interface AdvancedBird extends Bird.WaterBird {
    void dive();
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

Usage:

Penguin p = new Penguin();
p.swim();
p.dive();
2. Nested interface extending another nested interface
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
3. Lambda expression with nested interface

Because nested interfaces are implicitly static, they can be used as functional interfaces.

interface Machine {

    interface Switch {
        void turnOn();
    }
}

Usage:

Machine.Switch sw = () -> System.out.println("Machine turned ON");

sw.turnOn();
4. Multiple nested interfaces implemented together
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
5. Nested interface inside another nested interface
interface Vehicle {

    interface Engine {

        interface Electric {
            void charge();
        }
    }
}

class Tesla implements Vehicle.Engine.Electric {

    @Override
    public void charge() {
        System.out.println("Tesla charging");
    }
}

Usage:

Tesla t = new Tesla();
t.charge();
6. Static method inside nested interface
interface Shape {

    interface Calculator {

        static int square(int x) {
            return x * x;
        }
    }
}

Usage:

System.out.println(Shape.Calculator.square(5));

Output:

25
7. Default method inside nested interface
interface Vehicle {

    interface Electric {

        void charge();

        default void batteryStatus() {
            System.out.println("Battery is healthy");
        }
    }
}

Implementation:

class EVCar implements Vehicle.Electric {

    @Override
    public void charge() {
        System.out.println("Charging...");
    }
}

Usage:

EVCar car = new EVCar();
car.charge();
car.batteryStatus();
