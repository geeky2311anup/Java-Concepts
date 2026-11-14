interface A {
    int X = 10;

    void show();

    default void hello() {
        System.out.println("Hello from A");
    }

    static void info() {
        System.out.println("Static method in A");
    }
}

interface B {
    void display();

    default void hello() {
        System.out.println("Hello from B");
    }
}

interface D extends A, B {
    void extra();
}

class C implements D {
    public void show() {
        System.out.println("Hello");
    }

    public void display() {
        System.out.println("Java");
    }

    public void extra() {
        System.out.println("Extra from D, X = " + X);
    }

    @Override
    public void hello() {
        A.super.hello();
        B.super.hello();
    }
}

public class Main {
    public static void main(String[] args) {
        C a = new C();
        a.show();
        a.display();
        a.extra();
        a.hello();

        A b = a;
        b.show();

        B c = a;
        c.display();

        D d = a;
        d.extra();

        A.info();

        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        System.out.println(a instanceof D);
    }
}
