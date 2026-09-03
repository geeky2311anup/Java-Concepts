/*========================================================
              INTERFACE BASIC SYNTAX
========================================================*/

/*
An interface is a blueprint that defines
a set of methods and constants.

A class uses the 'implements' keyword
to implement an interface.
*/

interface Vehicle {

    // Automatically public static final
    int MAX_SPEED = 120;

    // Automatically public abstract
    void start();

    void stop();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}


/*========================================================
              MULTIPLE INTERFACE INHERITANCE
========================================================*/

/*
A class cannot extend multiple classes,
but it can implement multiple interfaces.

This is one of the main advantages of interfaces.
*/

interface Camera {

    void takePhoto();
}

interface MusicPlayer {

    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {

    @Override
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }
}


/*========================================================
              INTERFACE EXTENDING INTERFACE
========================================================*/

/*
An interface can extend another interface.

The child interface inherits the
methods of the parent interface.
*/

interface Animal {

    void eat();
}

interface Pet extends Animal {

    void play();
}

class Cat implements Pet {

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void play() {
        System.out.println("Cat plays");
    }
}


/*========================================================
              MULTIPLE INTERFACE EXTENSION
========================================================*/

/*
An interface can extend multiple interfaces.
*/

interface Printable {

    void print();
}

interface Scannable {

    void scan();
}

interface AllInOne extends Printable, Scannable {

    void fax();
}

class Printer implements AllInOne {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}


/*========================================================
              DEFAULT METHOD
========================================================*/

/*
Default methods were introduced in Java 8.

They allow an interface to provide
a method implementation.

The implementing class may override it,
but it is not mandatory.
*/

interface Vehicle2 {

    default void startEngine() {
        System.out.println("Engine started");
    }
}

class Bike implements Vehicle2 {

    // No need to override startEngine()
}

class DemoDefault {

    public static void main(String[] args) {

        Bike bike = new Bike();

        // Uses the default implementation
        bike.startEngine();
    }
}


/*========================================================
              OVERRIDING DEFAULT METHOD
========================================================*/

/*
A class can override a default method
provided by an interface.
*/

interface PrinterDevice {

    default void print() {
        System.out.println("Default printing");
    }
}

class LaserPrinter implements PrinterDevice {

    @Override
    public void print() {
        System.out.println("Laser printer printing");
    }
}


/*========================================================
              DEFAULT METHOD CONFLICT
========================================================*/

/*
If two interfaces contain the same default method,
the implementing class must resolve the conflict.

The class can provide its own implementation.
*/

interface First {

    default void show() {
        System.out.println("First");
    }
}

interface Second {

    default void show() {
        System.out.println("Second");
    }
}

class Test implements First, Second {

    @Override
    public void show() {
        System.out.println("Test implementation");
    }
}


/*========================================================
              SUPER INTERFACE METHOD CALL
========================================================*/

/*
When two interfaces have the same default method,
we can explicitly call a particular interface's
default implementation using:

InterfaceName.super.method()
*/

interface Left {

    default void display() {
        System.out.println("Left");
    }
}

interface Right {

    default void display() {
        System.out.println("Right");
    }
}

class MultipleDefault implements Left, Right {

    @Override
    public void display() {

        Left.super.display();

        // Right.super.display();
    }
}


/*========================================================
              INTERFACE TYPE CASTING
========================================================*/

/*
An interface reference can point to an object
of a class that implements that interface.

This is useful for abstraction and
runtime polymorphism.
*/

interface Soundable {

    void sound();
}

class Dog implements Soundable {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class InterfaceCasting {

    public static void main(String[] args) {

        Soundable obj = new Dog();

        // Calls Dog's implementation
        obj.sound();
    }
}


/*========================================================
              DOWNCASTING INTERFACE REFERENCE
========================================================*/

/*
An interface reference can be converted back
to the implementing class using casting.

The actual object must be compatible with
the target class.
*/

interface Flyable {

    void fly();
}

class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    void buildNest() {
        System.out.println("Bird builds nest");
    }
}

class CastingDemo {

    public static void main(String[] args) {

        Flyable obj = new Bird();

        obj.fly();

        // Downcasting
        Bird bird = (Bird) obj;

        bird.buildNest();
    }
}


/*========================================================
              INSTANCEOF WITH INTERFACE
========================================================*/

/*
Before downcasting, instanceof can be used
to check whether the object is compatible
with a particular class or interface.
*/

Flyable obj = new Bird();

if (obj instanceof Bird) {

    Bird bird = (Bird) obj;

    bird.buildNest();
}


/*========================================================
              INTERFACE AND LAMBDA
========================================================*/

/*
A functional interface can be implemented
using a lambda expression.

It must contain exactly ONE abstract method.

Default and static methods do not count.
*/

@FunctionalInterface
interface Greeting {

    void sayHello(String name);

    default void message() {
        System.out.println("Welcome");
    }
}

Greeting greeting =
        name -> System.out.println("Hello " + name);

greeting.sayHello("Anup");


/*========================================================
              FUNCTIONAL INTERFACE EXAMPLES
========================================================*/

/*
Some commonly used functional interfaces
are provided by Java.

Examples:

Predicate<T>  -> returns boolean
Function<T,R> -> returns a value
Consumer<T>   -> consumes a value
Supplier<T>   -> supplies a value
*/

import java.util.function.*;

class FunctionalDemo {

    public static void main(String[] args) {

        Predicate<Integer> checkEven =
                n -> n % 2 == 0;

        Function<Integer, Integer> square =
                n -> n * n;

        Consumer<String> print =
                text -> System.out.println(text);

        Supplier<String> message =
                () -> "Hello Java";

        System.out.println(checkEven.test(10));
        System.out.println(square.apply(5));
        print.accept("Welcome");
        System.out.println(message.get());
    }
}


/*========================================================
              EXTENDING FUNCTIONAL INTERFACE
========================================================*/

/*
A child interface can remain functional if
it does not introduce another abstract method.
*/

@FunctionalInterface
interface Operation {

    int execute(int a, int b);
}

@FunctionalInterface
interface Addition extends Operation {

    // Inherits execute()
}


/*========================================================
              INTERFACE OBJECT REFERENCE
========================================================*/

/*
An interface reference can point to any object
whose class implements that interface.
*/

interface Flyable2 {

    void fly();
}

interface Swimmable {

    void swim();
}

class Duck implements Flyable2, Swimmable {

    @Override
    public void fly() {
        System.out.println("Duck flies");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

class InterfaceReference {

    public static void main(String[] args) {

        Flyable2 f1 = new Duck();
        Swimmable s1 = new Duck();

        f1.fly();
        s1.swim();
    }
}


/*========================================================
              ABSTRACT CLASS + INTERFACE
========================================================*/

/*
A class can extend one abstract/concrete class
and implement multiple interfaces simultaneously.
*/

abstract class Machine {

    abstract void powerOn();
}

interface Connectable {

    void connect();
}

interface Rechargeable {

    void charge();
}

class Laptop extends Machine
        implements Connectable, Rechargeable {

    @Override
    public void powerOn() {
        System.out.println("Laptop ON");
    }

    @Override
    public void connect() {
        System.out.println("Connected");
    }

    @Override
    public void charge() {
        System.out.println("Charging");
    }
}


/*========================================================
              STATIC METHOD IN INTERFACE
========================================================*/

/*
Interface static methods belong to the interface.

They are NOT inherited by implementing classes.

Call them using the interface name.
*/

interface Utility {

    static void printMessage() {
        System.out.println("Utility Method");
    }
}

// Correct:
// Utility.printMessage();

// Incorrect:
// new Car().printMessage();


/*========================================================
              PRIVATE INTERFACE METHOD
========================================================*/

/*
Private methods can only be called from
inside the interface.

They are useful for sharing common logic
between default methods.
*/

interface Notification {

    default void email() {
        send("Email");
    }

    default void sms() {
        send("SMS");
    }

    private void send(String type) {
        System.out.println("Sending " + type);
    }
}


/*========================================================
              INTERFACE CONSTANTS
========================================================*/

/*
All variables declared inside an interface
are automatically:

public static final

Therefore they behave like constants.
*/

interface Constants {

    int MIN_VALUE = 10;

    String APP_NAME = "MyApp";
}

class ConstantDemo {

    public static void main(String[] args) {

        System.out.println(Constants.MIN_VALUE);
        System.out.println(Constants.APP_NAME);

        // Constants.MIN_VALUE = 20; // ERROR
    }
}


/*========================================================
              ABSTRACT CLASS VS INTERFACE
========================================================*/

/*

ABSTRACT CLASS:

1. Use 'extends'
2. A class can extend only one class
3. Can have constructors
4. Can have instance variables
5. Can have abstract and concrete methods
6. Can have different access modifiers

INTERFACE:

1. Use 'implements'
2. A class can implement multiple interfaces
3. Cannot be instantiated directly
4. Variables are public static final
5. Supports abstract, default and static methods
6. Private methods are also allowed

Use an abstract class when classes share
common state or implementation.

Use an interface when you want to define
a capability or contract.


/*========================================================
              INTERFACE POLYMORPHISM
========================================================*/

/*
One interface reference can represent
objects of different implementing classes.

This is runtime polymorphism.
*/

interface Payment {

    void pay();
}

class UPI implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment using UPI");
    }
}

class Card implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment using Card");
    }
}

class PaymentDemo {

    public static void main(String[] args) {

        Payment payment;

        payment = new UPI();
        payment.pay();

        payment = new Card();
        payment.pay();
    }
}


/*========================================================
              INTERFACE DESIGN PRINCIPLE
========================================================*/

/*
Prefer small, focused interfaces.

Bad:

interface Worker {

    void work();
    void eat();
    void sleep();
    void recharge();
}

A Robot may not need eat() or sleep().

Better:

interface Workable {

    void work();
}

interface RechargeableDevice {

    void recharge();
}

Classes implement only the capabilities
they actually need.

This follows the
Interface Segregation Principle (ISP).
*/


/*========================================================
              QUICK INTERVIEW TRAPS
========================================================*/

/*

1. Interface variables are implicitly:
   public static final

2. Interface methods without a body are:
   public abstract

3. Default methods are:
   public by default

4. Static interface methods:
   are not inherited

5. Private interface methods:
   cannot be accessed by implementing classes

6. A class can implement:
   multiple interfaces

7. An interface can extend:
   multiple interfaces

8. A functional interface contains:
   exactly one abstract method

9. An interface cannot be instantiated directly.

10. An interface reference can point to:
    an object of an implementing class.

11. If two interfaces have the same default method:
    the implementing class must resolve the conflict.

12. Interface static methods are called using:
    InterfaceName.method()

13. A class can:
    extend one class
    and implement multiple interfaces.

14. Lambda expressions work with:
    functional interfaces.

15. Private interface methods are useful for:
    reusing logic inside default methods.


/*========================================================
              ONE-LINE REVISION
========================================================*/

/*

Interface
   ↓
Defines a contract

implements
   ↓
Class follows the contract

default
   ↓
Method with implementation

static
   ↓
Belongs to interface

private
   ↓
Used internally inside interface

@FunctionalInterface
   ↓
Exactly one abstract method

Interface reference
   ↓
Supports abstraction + polymorphism

Multiple interfaces
   ↓
Allowed in Java

Interface Segregation Principle
   ↓
Keep interfaces small and focused

*/
