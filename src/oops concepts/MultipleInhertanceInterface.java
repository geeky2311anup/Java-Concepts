/*========================================================
              SUPER INTERFACE METHOD CALL
========================================================*/

/*
When two interfaces have the same default method,
the implementing class must resolve the conflict.

We can explicitly call a particular interface's
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
A class can be referenced using its interface type.

Example:

Animal a = new Dog();

This provides abstraction and allows
runtime polymorphism.
*/

Animal animal = new Dog();
animal.sound();


/*========================================================
              INTERFACE AND LAMBDA
========================================================*/

/*
A functional interface can be implemented
using a lambda expression.

Only ONE abstract method is allowed.
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
Interface reference can point to any object
whose class implements that interface.
*/

Flyable f1 = new Duck();
Swimmable s1 = new Duck();

f1.fly();
s1.swim();


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

8. A functional interface can contain:
   exactly one abstract method

9. Object cannot be created directly from:
   an interface

10. Interface can contain:
    abstract methods
    default methods
    static methods
    private methods
    constants


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

A Robot may not need eat().

Better:

interface Workable {
    void work();
}

interface Rechargeable {
    void recharge();
}

Classes implement only the
capabilities they actually need.

This is the Interface Segregation Principle.

*/
