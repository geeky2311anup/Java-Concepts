interface A {
    void swim();
}

interface B {
    void fly();
}

class C implements A, B {

    public void swim() {
        System.out.println("I can swim");
    }

    public void fly() {
        System.out.println("I can fly");
    }
}

public class MultipleInheritanceInterfaceExample {
    public static void main(String[] args) {

        C obj = new C();

        obj.swim();
        obj.fly();

        System.out.println("Class C implements both interfaces A and B.");
    }
}
