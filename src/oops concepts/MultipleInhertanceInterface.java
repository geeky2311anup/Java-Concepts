========================================
INTERSECTION TYPES
========================================

Java allows an object to satisfy multiple interface
contracts simultaneously through intersection types.

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {}
    public void swim() {}
}

Generic Intersection:

<T extends Flyable & Swimmable>

public static <T extends Flyable & Swimmable>
void move(T obj) {
    obj.fly();
    obj.swim();
}

Rules:
1. Maximum one class bound.
2. Class bound must appear first.
3. Unlimited interface bounds allowed.

Example:

<T extends Animal & Flyable & Swimmable>

========================================
MARKER INTERFACES
========================================

Marker Interfaces contain no methods.

interface Auditable {}

class Transaction implements Auditable {}

Purpose:
Provides metadata to JVM or frameworks.

Historical Examples:
----------------------------------
Serializable
Cloneable
Remote
RandomAccess

Example:

if(obj instanceof Serializable) {
    // Serialization logic
}

Modern Alternative:
Annotations often replace marker interfaces.

@Deprecated
@Override
@Entity

========================================
SEALED INTERFACES (JAVA 17)
========================================

Restrict which classes/interfaces may implement
an interface.

public sealed interface Shape
    permits Circle, Rectangle, Triangle {
}

final class Circle implements Shape {}
final class Rectangle implements Shape {}
final class Triangle implements Shape {}

Benefits:
1. Exhaustive modeling.
2. Better compiler checks.
3. Pattern matching support.
4. Strong domain constraints.

========================================
NON-SEALED INTERFACES
========================================

A permitted subtype can reopen inheritance.

sealed interface Vehicle
    permits Car, Bike {}

non-sealed class Car implements Vehicle {}

class SportsCar extends Car {}
class ElectricCar extends Car {}

final class Bike implements Vehicle {}

Meaning:
Inheritance continues freely from Car.

========================================
PATTERN MATCHING WITH SEALED INTERFACES
========================================

sealed interface Shape
    permits Circle, Rectangle {}

record Circle(double radius) implements Shape {}
record Rectangle(double w, double h) implements Shape {}

static double area(Shape shape) {
    return switch(shape) {

        case Circle c ->
            Math.PI * c.radius() * c.radius();

        case Rectangle r ->
            r.w() * r.h();
    };
}

Compiler knows all possible implementations.

No default case required.

========================================
RECORDS + INTERFACES
========================================

Records can implement interfaces.

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

Records cannot extend classes,
but can implement multiple interfaces.

========================================
INTERFACE CONSTANTS
========================================

All interface fields are implicitly:

public static final

interface Constants {

    int MAX_SIZE = 100;

    String APP_NAME = "Inventory";
}

Compiler converts to:

public static final int MAX_SIZE = 100;

Usage:

int size = Constants.MAX_SIZE;

Best Practice:
Avoid "constant interfaces".
Prefer utility classes.

public final class Constants {
    private Constants() {}
    public static final int MAX_SIZE = 100;
}

========================================
NESTED INTERFACES
========================================

Interfaces may contain nested interfaces.

interface Engine {

    interface Specification {
        int getHorsePower();
    }
}

class PetrolSpec
        implements Engine.Specification {

    public int getHorsePower() {
        return 200;
    }
}

Useful for grouping related contracts.

========================================
GENERIC INTERFACES
========================================

Interfaces can be generic.

interface Repository<T> {
    void save(T obj);
    T findById(int id);
}

class UserRepository
        implements Repository<User> {

    public void save(User user) {}

    public User findById(int id) {
        return null;
    }
}

Benefits:
1. Reusability
2. Type Safety
3. Compile-time checking

========================================
COVARIANT RETURN TYPES
========================================

Implementations may return more specific types.

interface AnimalFactory {
    Animal create();
}

class DogFactory
        implements AnimalFactory {

    @Override
    public Dog create() {
        return new Dog();
    }
}

Dog is a subtype of Animal.

Allowed by Java compiler.

========================================
INTERFACE SEGREGATION PRINCIPLE (ISP)
========================================

Clients should not depend on methods
they do not use.

Bad Design:

interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {

    public void work() {}

    public void eat() {
        throw new UnsupportedOperationException();
    }
}

Good Design:

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human
        implements Workable, Eatable {}

class Robot
        implements Workable {}

========================================
DYNAMIC PROXY WITH INTERFACES
========================================

Interfaces enable runtime proxy generation.

interface Service {
    void execute();
}

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

Used By:
----------------------------------
Spring AOP
JDK Proxies
RPC Frameworks
Feign Clients

========================================
JVM INTERNALLY: ITABLE
========================================

Classes use:
----------------------------------
VTABLE (Virtual Method Table)

Interfaces use:
----------------------------------
ITABLE (Interface Method Table)

During method invocation:

interface Animal {
    void sound();
}

Animal a = new Dog();
a.sound();

JVM performs:

1. Resolve interface reference.
2. Lookup implementation in ITABLE.
3. Dispatch correct concrete method.

This allows:

- Runtime polymorphism
- Multiple interface inheritance
- Efficient dynamic dispatch

========================================
DEFAULT METHOD CONFLICT RESOLUTION
========================================

Priority Rules:

Rule 1:
Class wins over Interface.

Rule 2:
More specific Interface wins.

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

class Test implements B {}

Output:
B

Rule 3:
Explicit override required if ambiguity remains.

interface X {
    default void print() {}
}

interface Y {
    default void print() {}
}

class Demo implements X, Y {

    @Override
    public void print() {
        X.super.print();
    }
}

========================================
INTERFACES IN MODERN JAVA DESIGN
========================================

Primary Uses Today:

✓ Functional Programming
✓ Dependency Injection
✓ Spring Services
✓ Repository Pattern
✓ Strategy Pattern
✓ Adapter Pattern
✓ SPI Plugins
✓ Microservice Contracts
✓ Dynamic Proxies
✓ Reactive APIs
✓ Event Systems

Rule of Thumb:

Use Interface When:
----------------------------------
- Defining behavior
- Multiple implementations expected
- API abstraction needed
- Dependency inversion required

Use Abstract Class When:
----------------------------------
- Shared state exists
- Common implementation dominates
- Constructors are required
- Protected members are needed

Interview One-Liner:

"Interfaces define capabilities,
Abstract Classes define identity."
