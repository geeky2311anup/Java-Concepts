interface Bird{
    public void fly();
    public interface NonFlyingBird{ // nested interface must have public access modifier if its inside interface
        public void run();
    }
}
 class Dog{
    public void bark(){
        System.out.println("Dog barks");
    }
    private interface Pet{ // nested interface can have private access modifier if its inside class
        public void play();
    }
    class Puppy implements Pet{
        @Override
        public void play(){
            System.out.println("Puppy plays");  
        }
 }
 }

class parrot implements Bird{
    @Override
    public void fly(){
        System.out.println("Parrot can fly");
    }
}
class Ostrich implements Bird.NonFlyingBird{
    @Override
    public void run(){
        System.out.println("Ostrich can run");
    }
}
public class NestedInterface{
    public static void main(String[] args){
        parrot p = new parrot();
        p.fly();
        Ostrich o = new Ostrich();
        o.run();
        //o.fly();
        Dog dog = new Dog();
        dog.bark();
        Dog.Puppy puppy = dog.new Puppy();
        puppy.play();
    }
}