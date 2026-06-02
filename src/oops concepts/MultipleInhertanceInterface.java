// ========================================
// MULTIPLE INHERITANCE USING INTERFACES
// ========================================

// Interface A
interface A {
    void display();
}

// Interface B
interface B {
    void show();
}

// Interface D
interface D {
    void print();
}

// Class C implements multiple interfaces
class C implements A, B, D {

    @Override
    public void display() {
        System.out.println("Display method from Interface A");
    }

    @Override
    public void show() {
        System.out.println("Show method from Interface B");
    }

    @Override
    public void print() {
        System.out.println("Print method from Interface D");
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        C obj = new C();

        obj.display();
        obj.show();
        obj.print();

        System.out.println();

        // Interface Reference Variables
        A a = obj;
        B b = obj;
        D d = obj;

        a.display();
        b.show();
        d.print();
    }
}

/*
========================================
OUTPUT
========================================

Display method from Interface A
Show method from Interface B
Print method from Interface D

Display method from Interface A
Show method from Interface B
Print method from Interface D

========================================
ADVANTAGES OF INTERFACES
========================================

1. Supports Multiple Inheritance

   class C implements A, B, D

   A class can implement multiple interfaces
   at the same time.

2. Achieves Abstraction

   Interfaces provide method declarations
   without implementation.

3. Promotes Loose Coupling

   Programs depend on interfaces rather
   than concrete classes.

4. Improves Reusability

   Multiple classes can implement the
   same interface.

5. Supports Polymorphism

   A a = new C();

   The interface reference can point
   to any implementing object.

========================================
WHY JAVA DOES NOT ALLOW
MULTIPLE INHERITANCE USING CLASSES
========================================

Suppose:

class A {
    void show() {
        System.out.println("A");
    }
}

class B {
    void show() {
        System.out.println("B");
    }
}

class C extends A, B   // ERROR

Now if:

C obj = new C();
obj.show();

Java cannot decide whether to call
A's show() or B's show().

This problem is called:

        DIAMOND PROBLEM

To avoid ambiguity, Java does not
support multiple inheritance through
classes.

========================================
INTERVIEW QUESTION
========================================

Q. Can an interface extend multiple
interfaces?

Yes.

Example:

interface A {
    void display();
}

interface B {
    void show();
}

interface C extends A, B {
    void print();
}

Now any class implementing C must
implement all three methods.

========================================
CONCLUSION
========================================

✔ Java does not support multiple
  inheritance using classes.

✔ Java supports multiple inheritance
  using interfaces.

✔ A class can implement multiple
  interfaces.

✔ Interfaces help achieve abstraction,
  polymorphism, and loose coupling.

========================================
*/
