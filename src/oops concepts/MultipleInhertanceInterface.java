/*
========================================
NESTED INTERFACES
========================================

An interface can be declared inside
another interface or class.

interface Outer {

    interface Inner {
        void show();
    }
}

class Test implements Outer.Inner {

    public void show() {
        System.out.println("Inner Interface");
    }
}

========================================
INTERFACE INHERITANCE CHAIN
========================================

interface A {
    void m1();
}

interface B extends A {
    void m2();
}

class Test implements B {

    public void m1() {
        System.out.println("M1");
    }

    public void m2() {
        System.out.println("M2");
    }
}

A single interface can be extended
through multiple levels.

========================================
WHY INTERFACE VARIABLES ARE FINAL
========================================

interface Demo {
    int x = 10;
}

Demo.x = 20; // Compile Error

Reason:
All interface variables are

public static final

and cannot be modified.

========================================
EMPTY INTERFACE VS MARKER INTERFACE
========================================

Marker Interface examples:

Serializable
Cloneable
Remote

Purpose:
Provide special information to JVM
or Frameworks.

========================================
ANONYMOUS CLASS WITH INTERFACE
========================================

interface Greeting {
    void hello();
}

Greeting g = new Greeting() {

    public void hello() {
        System.out.println("Hello");
    }
};

g.hello();

Used before Lambda Expressions.

========================================
LAMBDA EXPRESSIONS
========================================

@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

Calculator c = (a, b) -> a + b;

System.out.println(c.add(10, 20));

Output:
30

Works only with Functional Interfaces.

========================================
BUILT-IN FUNCTIONAL INTERFACES
========================================

1. Predicate<T>

Predicate<Integer> p =
        x -> x > 10;

p.test(15);

----------------------------------------

2. Function<T,R>

Function<Integer,Integer> f =
        x -> x * x;

f.apply(5);

----------------------------------------

3. Consumer<T>

Consumer<String> c =
        s -> System.out.println(s);

c.accept("Hello");

----------------------------------------

4. Supplier<T>

Supplier<String> s =
        () -> "Java";

s.get();

========================================
INTERFACE REFERENCE
========================================

interface Animal {
    void sound();
}

class Dog implements Animal {

    public void sound() {
        System.out.println("Bark");
    }
}

Animal a = new Dog();

a.sound();

Output:
Bark

This demonstrates runtime polymorphism.

========================================
CASTING WITH INTERFACES
========================================

Animal a = new Dog();

Dog d = (Dog) a;

Downcasting is allowed when
the object actually belongs
to that class.

========================================
SEALED INTERFACES (JAVA 17)
========================================

public sealed interface Shape
permits Circle, Rectangle {

}

final class Circle
implements Shape {

}

final class Rectangle
implements Shape {

}

Only permitted classes can
implement the interface.

========================================
RECORDS IMPLEMENTING INTERFACE
========================================

interface Shape {
    double area();
}

record Circle(double radius)
implements Shape {

    public double area() {
        return 3.14 * radius * radius;
    }
}

Records can implement interfaces.

========================================
INTERFACE AND ENUM
========================================

interface Operation {
    int apply(int a, int b);
}

enum Calculator
implements Operation {

    ADD {
        public int apply(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        public int apply(int a, int b) {
            return a - b;
        }
    };
}

Enums can implement interfaces.

========================================
COMPARABLE INTERFACE
========================================

class Student
implements Comparable<Student> {

    int id;

    Student(int id) {
        this.id = id;
    }

    public int compareTo(Student s) {
        return this.id - s.id;
    }
}

Used for natural sorting.

Collections.sort(list);

========================================
COMPARATOR INTERFACE
========================================

Comparator<Student> c =
    (a, b) -> a.id - b.id;

Collections.sort(list, c);

Used for custom sorting.

========================================
INTERFACE SEGREGATION PRINCIPLE
(SOLID)
========================================

Bad:

interface Worker {
    void work();
    void eat();
}

Robot must implement eat()
unnecessarily.

Good:

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

Classes implement only
required interfaces.

========================================
DIAMOND PROBLEM RESOLUTION
========================================

interface A {

    default void show() {
        System.out.println("A");
    }
}

interface B {

    default void show() {
        System.out.println("B");
    }
}

class C implements A, B {

    @Override
    public void show() {
        A.super.show();
    }
}

Output:
A

Specific interface default method
can be called using:

InterfaceName.super.method()

========================================
INTERFACE VS ABSTRACT CLASS
(INTERVIEW TABLE)
========================================

Interface
--------------------------------
Multiple Inheritance     Yes
Constructor              No
Instance Variables       No
100% Abstraction*        Yes
Static Methods           Yes
Default Methods          Yes

Abstract Class
--------------------------------
Multiple Inheritance     No
Constructor              Yes
Instance Variables       Yes
Partial Abstraction      Yes
Static Methods           Yes
Concrete Methods         Yes

(*Before Java 8)

========================================
COMMON INTERVIEW QUESTIONS
========================================

Q. Why doesn't Java support
multiple inheritance with classes?

Because of the Diamond Problem.

----------------------------------------

Q. Why use interfaces?

To achieve:
1. Abstraction
2. Polymorphism
3. Loose Coupling
4. Multiple Inheritance

----------------------------------------

Q. Can interfaces have main() method?

Yes.

interface Demo {

    static void main(String[] args) {
        System.out.println("Hello");
    }
}

----------------------------------------

Q. Can interfaces contain nested classes?

Yes.

interface A {

    class Demo {

    }
}

----------------------------------------

Q. Can we override static methods
of interfaces?

No.

Static methods belong to the
interface itself.

========================================
MOST IMPORTANT JAVA INTERFACES
========================================

Runnable
Comparable
Comparator
Iterable
Collection
List
Set
Queue
Map
AutoCloseable
Serializable
Cloneable
Callable

These are heavily used in
real-world Java applications.

========================================
*/
