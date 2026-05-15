abstract class Vehicle {

    // Abstract method
    abstract void start();

    // Normal method
    void fuel() {
        System.out.println("Vehicle needs fuel");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();

        c.start();
        c.fuel();
    }
}
