// Interface A
// Contains one abstract method
interface A {

    void display();
}


// Interface B
// Contains another abstract method
interface B {

    void show();
}


// Class C implements both interfaces
// This is how Java supports Multiple Inheritance
// using Interfaces
class C implements A, B {

    // Overriding method of Interface A
    public void display() {

        System.out.println("Display method from Interface A");
    }

    // Overriding method of Interface B
    public void show() {

        System.out.println("Show method from Interface B");
    }
}


// Main class
public class Main {

    public static void main(String[] args) {

        // Creating object of class C
        C obj = new C();

        // Calling method from Interface A
        obj.display();

        // Calling method from Interface B
        obj.show();
    }
}


/*
========================================
OUTPUT
========================================

Display method from Interface A
Show method from Interface B


========================================
EXPLANATION
========================================

1. Java does NOT support Multiple Inheritance
   using classes directly.

   Example (NOT ALLOWED):
   class C extends A, B

2. Java supports Multiple Inheritance
   using Interfaces.

3. Here:
   - Interface A provides display()
   - Interface B provides show()

4. Class C implements both interfaces.

5. Therefore, class C gets features
   from both A and B.

========================================
*/
