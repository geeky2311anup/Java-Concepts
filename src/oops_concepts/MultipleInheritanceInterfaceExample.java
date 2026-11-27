interface A {
    public void swim();

    public void dive();
}

interface B {
    public void fly();

    public void land();
}

class C implements A, B {

    public void swim() {
        System.out.println("Swimming in water");
    }

    public void dive() {
        System.out.println("Diving underwater");
    }

    public void fly() {
        System.out.println("Flying in the sky");
    }

    public void land() {
        System.out.println("Landing safely");
    }
}

public class MultipleInheritanceInterfaceExample {

    public static void main(String[] args) {

        C obj = new C();

        obj.swim();
        obj.dive();
        obj.fly();
        obj.land();
    }
}
