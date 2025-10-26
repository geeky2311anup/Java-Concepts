interface Bird{
    public static final String color = "varied"; // defining variable in interface is compulsory
    public void fly();
}
abstract class parrot implements Bird{
    @Override
    public void fly(){     //if we want we can leave it without oberriding because parrot is abstract class but if it would have been concrete class then it must override fly() method
        System.out.println("Parrot can fly");
    }
    public abstract void sing();
}
class MyParrot extends parrot{
    @Override
    public void sing(){
        System.out.println("My parrot can sing");
    }
    public void eat (){
        System.out.println("My parrot can eat");
    }
}
public class AbstractClassImplementationOfInterface{
    public static void main(String[] args){
        MyParrot myParrot = new MyParrot();
        myParrot.fly();
        myParrot.sing();
        parrot p = new MyParrot();
        p.fly();
        p.sing();
        //p.eat(); //give error because reference type is parrot and it does not have eat() method
        Bird b = new MyParrot();
        b.fly();
        //b.sing(); //give error because reference type is Bird and it does not have
    }
}