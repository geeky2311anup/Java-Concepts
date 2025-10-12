class Parent{
    public void show(){
        System.out.println("Parent show method");
    }
}
class Child extends Parent{
    public void show(){  // overriding the show method
        System.out.println("Child show method");
    }
    public void display(){
        System.out.println("Child specific display method");
    }
}
public class PolymorphismMethodOverriding{
    public static void main(String[] args){
        Parent obj = new Child(); // upcasting
        obj.show();  // calls Child's show method due to runtime polymorphism
      //  obj.display(); // give error because display() is not in Parent class
        Child obj2 = new Child(); // no upcasting
        //obj2.show();  // calls Child's show method
        obj2.display(); // works fine, calls display() from Child class
        Parent obj3 = new Parent();
        obj3.show();
    }
}