class A {
    public void motivation() {
        System.out.println("Never give up");
    }
}

class B {
    public void motivation() {
        System.out.println("Never get demotivated");
    }
}

// Java does not support multiple inheritance using classes.
// class C extends A, B { }  // ERROR

// Multiple inheritance can be achieved using interfaces.

interface X {
    void motivation();
}

interface Y {
    void motivation();
}

// C implements multiple interfaces
class C implements X, Y {

    // Both interfaces contain the same method.
    // C provides its own implementation to remove ambiguity.
    @Override
    public void motivation() {
        System.out.println("Keep working hard and never give up!");
    }

    public void study() {
        System.out.println("Study every day.");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {

        // Using class inheritance
        A objA = new A();
        objA.motivation();

        B objB = new B();
        objB.motivation();

        System.out.println();

        // Multiple inheritance using interfaces
        C objC = new C();
        objC.motivation();
        objC.study();
    }
}
