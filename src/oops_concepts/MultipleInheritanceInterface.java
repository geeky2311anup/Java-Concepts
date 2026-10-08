interface A{
    public void display();
}
interface B{
    public void display();
}
interface C extends A, B{  // Interface extends other interfaces
    // No implementation here - just inherits the abstract method
}

class MyClass implements C{  // Class implements interface

    @Override
    public void display(){
        System.out.println("display method from MyClass");
    }
}
//we can also do like
class MyClass2 implements A, B{  // Class implements multiple interfaces
    public void display(){
        System.out.println("display method from MyClass2");
    }
}
public class MultipleInheritanceInterface{
    public static void main(String[] args){
        MyClass obj = new MyClass();  // Create object of class, not interface
        obj.display();


        @FunctionalInterface
interface TaskA {
    void execute();
}

@FunctionalInterface
interface TaskB {
    void execute();
}

@FunctionalInterface
interface CombinedTask extends TaskA, TaskB {
    // Inherits single abstract method 'void execute()'
}

public class LambdaTest {
    public static void main(String[] args) {
        // Lambda assigned directly to CombinedTask
        CombinedTask task = () -> System.out.println("Executing combined task!");
        task.execute();
    }
}
        
        // You can also use interface reference
        C objC = new MyClass();
        objC.display();
    }
}   
