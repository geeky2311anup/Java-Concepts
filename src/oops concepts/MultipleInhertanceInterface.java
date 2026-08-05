/*
=========================================================
                JAVA INTERFACES - COMPLETE NOTES
=========================================================

1. Basic Interfaces
2. Multiple Inheritance
3. Default Methods
4. Static Methods
5. Private Methods (Java 9)
6. Functional Interfaces
7. Intersection Types
8. Marker Interfaces
9. Sealed Interfaces (Java 17)
10. Non-Sealed Interfaces
11. Pattern Matching
12. Records + Interfaces
13. Interface Constants
14. Nested Interfaces
15. Generic Interfaces
16. Covariant Return Types
17. Interface Segregation Principle
18. Dynamic Proxy
19. JVM ITABLE
20. Default Method Conflict Resolution
21. Interface Inheritance
22. Diamond Problem
23. Modern Java Uses
24. Interface vs Abstract Class
25. Interview Questions
=========================================================
*/

import java.io.Serializable;
import java.lang.reflect.Proxy;

/*========================================================
                    BASIC INTERFACE
========================================================*/

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

/*========================================================
                MULTIPLE INTERFACE INHERITANCE
========================================================*/

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void swim() {
        System.out.println("Swimming");
    }
}

/*========================================================
                  DEFAULT METHODS
========================================================*/

interface Vehicle {

    default void start() {
        System.out.println("Vehicle Started");
    }
}

class Car implements Vehicle {}

/*========================================================
                   STATIC METHODS
========================================================*/

interface MathUtil {

    static int square(int x) {
        return x * x;
    }
}

/*========================================================
                  PRIVATE METHODS (JAVA 9)
========================================================*/

interface Logger {

    default void info() {
        print("INFO");
    }

    default void error() {
        print("ERROR");
    }

    private void print(String msg) {
        System.out.println(msg);
    }
}

/*========================================================
              FUNCTIONAL INTERFACE
========================================================*/

@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);

    default void show() {}

    static void display() {}
}

/*========================================================
                INTERSECTION TYPES
========================================================*/

class BirdFish implements Flyable, Swimmable {

    public void fly() {
        System.out.println("Fly");
    }

    public void swim() {
        System.out.println("Swim");
    }
}

class GenericDemo {

    public static <T extends Flyable & Swimmable>
    void move(T obj) {

        obj.fly();
        obj.swim();
    }
}

/*
Rules:

1. Maximum one class bound.
2. Class bound first.
3. Unlimited interfaces.

<T extends AnimalClass & Flyable & Swimmable>

*/

/*========================================================
                MARKER INTERFACES
========================================================*/

interface Auditable {}

class Transaction implements Auditable {}

/*
Historical Marker Interfaces

Serializable
Cloneable
Remote
RandomAccess

*/

/*========================================================
                 SEALED INTERFACES
========================================================*/

sealed interface Shape
        permits Circle, Rectangle, Triangle {}

final class Circle implements Shape {}

final class Rectangle implements Shape {}

final class Triangle implements Shape {}

/*========================================================
                NON SEALED INTERFACE
========================================================*/

sealed interface VehicleType
        permits CarType, BikeType {}

non-sealed class CarType
        implements VehicleType {}

class SportsCar extends CarType {}

class ElectricCar extends CarType {}

final class BikeType
        implements VehicleType {}

/*========================================================
          PATTERN MATCHING (JAVA 21)
========================================================*/

sealed interface Figure
        permits CircleRec, RectangleRec {}

record CircleRec(double radius)
        implements Figure {}

record RectangleRec(double w, double h)
        implements Figure {}

class PatternMatching {

    static double area(Figure shape) {

        return switch (shape) {

            case CircleRec c ->
                    Math.PI * c.radius() * c.radius();

            case RectangleRec r ->
                    r.w() * r.h();
        };
    }
}

/*========================================================
               RECORDS + INTERFACES
========================================================*/

interface Printable {

    void print();
}

record Employee(String name, int age)
        implements Printable {

    @Override
    public void print() {
        System.out.println(name + " " + age);
    }
}

/*========================================================
                INTERFACE CONSTANTS
========================================================*/

interface Constants {

    int MAX_SIZE = 100;

    String APP_NAME = "Inventory";
}

/*
Compiler converts to:

public static final int MAX_SIZE

Best Practice:

Use Utility Class instead.

*/

/*========================================================
                NESTED INTERFACES
========================================================*/

interface Engine {

    interface Specification {

        int horsePower();
    }
}

class PetrolSpecification
        implements Engine.Specification {

    public int horsePower() {
        return 200;
    }
}

/*========================================================
               GENERIC INTERFACES
========================================================*/

interface Repository<T> {

    void save(T obj);

    T findById(int id);
}

class User {}

class UserRepository
        implements Repository<User> {

    public void save(User user) {}

    public User findById(int id) {
        return null;
    }
}

/*========================================================
            COVARIANT RETURN TYPES
========================================================*/

class AnimalType {}

class DogType extends AnimalType {}

interface AnimalFactory {

    AnimalType create();
}

class DogFactory
        implements AnimalFactory {

    @Override
    public DogType create() {
        return new DogType();
    }
}

/*========================================================
        INTERFACE SEGREGATION PRINCIPLE
========================================================*/

interface Workable {

    void work();
}

interface Eatable {

    void eat();
}

class Human
        implements Workable, Eatable {

    public void work() {}

    public void eat() {}
}

class Robot
        implements Workable {

    public void work() {}
}

/*========================================================
              DYNAMIC PROXY
========================================================*/

interface Service {

    void execute();
}

class RealService
        implements Service {

    public void execute() {
        System.out.println("Executing...");
    }
}

/*
Example:

Service proxy =
(Service) Proxy.newProxyInstance(
    Service.class.getClassLoader(),
    new Class<?>[]{Service.class},
    (obj, method, args) -> {

        System.out.println("Before");

        Object result =
            method.invoke(realObject, args);

        System.out.println("After");

        return result;
    });

Used By

Spring AOP
Feign
RPC
JDK Dynamic Proxy

*/

/*========================================================
                    JVM ITABLE
========================================================*/

/*
Classes:
VTABLE

Interfaces:
ITABLE

Animal a = new Dog();

a.sound();

JVM:

1. Resolve interface
2. Lookup ITABLE
3. Invoke implementation

*/

/*========================================================
       DEFAULT METHOD CONFLICT RESOLUTION
========================================================*/

interface A {

    default void show() {
        System.out.println("A");
    }
}

interface B extends A {

    default void show() {
        System.out.println("B");
    }
}

class Test1
        implements B {}

/*
Rule 1

Class wins.

Rule 2

More specific interface wins.

Rule 3

Otherwise override explicitly.

*/

interface X {

    default void print() {
        System.out.println("X");
    }
}

interface Y {

    default void print() {
        System.out.println("Y");
    }
}

class Demo
        implements X, Y {

    @Override
    public void print() {
        X.super.print();
    }
}

/*========================================================
            INTERFACE INHERITANCE
========================================================*/

interface First {

    void a();
}

interface Second {

    void b();
}

interface Third
        extends First, Second {

    void c();
}

/*========================================================
                DIAMOND PROBLEM
========================================================*/

/*
Java avoids diamond problem.

If two interfaces provide same
default method, compiler forces
override.

*/

/*========================================================
            INTERFACE VS ABSTRACT CLASS
========================================================*/

/*

Interface

✔ Multiple inheritance
✔ No constructors
✔ No state
✔ Behavior

Abstract Class

✔ Constructors
✔ State
✔ Protected members
✔ Shared implementation

*/

/*========================================================
                MODERN JAVA USES
========================================================*/

/*

Functional Programming

Dependency Injection

Repository Pattern

Strategy Pattern

Adapter Pattern

Factory Pattern

Observer Pattern

SPI

Spring Services

Microservices

Reactive APIs

Dynamic Proxy

*/

/*========================================================
            COMMON INTERVIEW QUESTIONS
========================================================*/

/*

Q. Can interface have constructors?
No.

Q. Can interface extend class?
No.

Q. Can interface extend interfaces?
Yes.

Q. Can class implement multiple interfaces?
Yes.

Q. Can interface have fields?
Yes
(public static final)

Q. Can interface have static methods?
Yes.

Q. Can interface have private methods?
Yes (Java 9)

Q. Can interface have default methods?
Yes (Java 8)

Q. Can records implement interfaces?
Yes.

Q. Can enums implement interfaces?
Yes.

Q. Can interface be final?
No.

Q. Can interface be sealed?
Yes.

Q. Can interface be instantiated?
No.

*/

/*========================================================
                INTERVIEW ONE-LINERS
========================================================*/

/*

Interfaces define behavior,
Abstract Classes define identity.

Interfaces support multiple
inheritance of type,
not state.

Default methods were introduced
for backward compatibility.

Functional interfaces power
Lambda Expressions.

Sealed interfaces restrict
inheritance.

Interface fields are always

public static final

*/

/*========================================================
                    MAIN METHOD
========================================================*/

public class InterfaceNotes {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.sound();

        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        Car car = new Car();
        car.start();

        Calculator add = (a, b) -> a + b;
        System.out.println(add.calculate(5, 6));

        System.out.println(MathUtil.square(8));

        Employee e = new Employee("John", 25);
        e.print();

        System.out.println(Constants.APP_NAME);

        if (e instanceof Serializable) {
            System.out.println("Serializable");
        }

        GenericDemo.move(new BirdFish());
    }
}
