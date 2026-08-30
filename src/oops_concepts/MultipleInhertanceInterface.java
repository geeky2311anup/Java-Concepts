interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {
    public void show() {
        System.out.println("Hello");
    }

    public void display() {
        System.out.println("Java");
    }
}
