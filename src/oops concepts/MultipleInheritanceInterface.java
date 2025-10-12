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
        
        // You can also use interface reference
        C objC = new MyClass();
        objC.display();
    }
}   
