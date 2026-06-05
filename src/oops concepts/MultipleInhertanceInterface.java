/*
========================================
TYPES OF INTERFACES IN JAVA
========================================

1. Normal Interface

interface Animal {
    void sound();
}

2. Functional Interface
   (Contains exactly one abstract method)

@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

Used with Lambda Expressions.

3. Marker Interface
   (No methods)

interface Serializable {}

Used to provide metadata to JVM.

========================================
DEFAULT METHODS (Java 8)
========================================

Interfaces can have method bodies.

interface A {
    default void show() {
        System.out.println("Default Show");
    }
}

class Test implements A {}

Test obj = new Test();
obj.show();

Output:
Default Show

Benefit:
New methods can be added to interfaces
without breaking existing classes.

========================================
STATIC METHODS IN INTERFACES
========================================

interface MathUtil {

    static void display() {
        System.out.println("Static Method");
    }
}

MathUtil.display();

Output:
Static Method

Static methods belong to interface itself.

========================================
PRIVATE METHODS IN INTERFACES
(Java 9)
========================================

interface Demo {

    private void helper() {
        System.out.println("Private Method");
    }

    default void show() {
        helper();
    }
}

Used for code reuse inside interface.

========================================
MULTIPLE INHERITANCE WITH
DEFAULT METHODS
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
        System.out.println("Resolved");
    }
}

Why Override?

Because both interfaces provide
the same default method and Java
cannot decide which one to use.

========================================
ACCESS MODIFIERS IN INTERFACES
========================================

Methods inside interface are
implicitly:

public abstract

Example:

interface A {
    void display();
}

Actually means:

interface A {
    public abstract void display();
}

Variables inside interface are
implicitly:

public static final

Example:

interface A {
    int x = 10;
}

Actually means:

public static final int x = 10;

========================================
INTERFACE VS ABSTRACT CLASS
========================================

INTERFACE

✔ Supports multiple inheritance
✔ All variables are constants
✔ No constructors
✔ Used for capability definition

ABSTRACT CLASS

✔ Partial abstraction
✔ Can have constructors
✔ Can have instance variables
✔ Single inheritance only

Example:

abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Stopped");
    }
}

========================================
REAL WORLD EXAMPLE
========================================

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {

    public void fly() {
        System.out.println("Duck Flying");
    }

    public void swim() {
        System.out.println("Duck Swimming");
    }
}

Duck demonstrates multiple
inheritance through interfaces.

========================================
INTERVIEW QUESTIONS
========================================

Q1. Can we create an object of an
interface?

No.

A obj = new A(); // Error

Interfaces cannot be instantiated.

----------------------------------------

Q2. Can an interface have a constructor?

No.

Interfaces do not have constructors
because objects cannot be created.

----------------------------------------

Q3. Can an interface extend a class?

No.

Interface can extend only interfaces.

----------------------------------------

Q4. Can a class extend a class and
implement interfaces simultaneously?

Yes.

class A {}

interface B {}

class C extends A implements B {}

----------------------------------------

Q5. Can one interface extend multiple
interfaces?

Yes.

interface A {}
interface B {}

interface C extends A, B {}

----------------------------------------

Q6. Can an abstract class implement
an interface?

Yes.

interface A {
    void show();
}

abstract class B implements A {
}

The abstract class may choose not
to implement all methods.

----------------------------------------

Q7. Which is faster:
Abstract Class or Interface?

Practically no noticeable difference
in modern JVM implementations.

Choose based on design requirements,
not performance.

========================================
JAVA MEMORY CONCEPT
========================================

A a = new C();

Reference Type : A
Object Type    : C

Compile Time:
Only methods available in A
can be accessed.

Run Time:
Methods of C execute due to
Dynamic Method Dispatch.

========================================
BEST PRACTICE
========================================

Program to Interfaces,
not Implementations.

Good:

List<Integer> list =
        new ArrayList<>();

Bad:

ArrayList<Integer> list =
        new ArrayList<>();

This increases flexibility and
reduces coupling.

========================================
FINAL CONCLUSION
========================================

✔ Interface provides 100% abstraction
  (before Java 8).

✔ Java supports Multiple Inheritance
  through Interfaces.

✔ Interfaces support Polymorphism.

✔ Methods are public abstract by
  default.

✔ Variables are public static final
  by default.

✔ Interfaces can contain Default,
  Static and Private methods.

✔ Interfaces are heavily used in
  Frameworks, Spring, JDBC,
  Collections Framework and
  Enterprise Applications.

========================================
*/
