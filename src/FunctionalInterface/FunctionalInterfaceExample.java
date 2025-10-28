
//functional interface is an interface that contains only one abstract method also known as Single Abstract Method(SAM) interface
@FunctionalInterface          //this annotation is optional but it is good practice to use it
interface LivingThings{           //functional interface
    public void canBreathe();      //abstract method
}
@FunctionalInterface          //this annotation is optional but it is good practice to use it
interface NonLivingThings{
    public void canDecay();       //abstract method
    //public void canBreak();     //if we uncomment this line then it will give error because functional interface can have only one abstract method and @FunctionalInterface annotation will check this condition
}

interface Mammals{
    public void canWalk();       //abstract method
    default boolean canSleep(){//we can have default method in functional interface
        return true;
    }
    static boolean hasCells(){ //we can have static method in functional interface
        return true;
    }

    String toString(); //we can have methods of Object class in functional interface
}
class Dog implements Mammals{
    @Override
    public void canWalk(){
        System.out.println("Dog can walk");
    }
}

//functional interface extends functional interface
@FunctionalInterface
interface Canine extends LivingThings{
    //public void canBark();//if we uncomment this will give error because functional interface can have only one abstract method
    public void canBreathe();//this will not give error because it is same as canBreathe() method of LivingThings interface
}

public class FunctionalInterfaceExample{
    public static void main(String[] args ){
        Dog lebrador = new Dog();
        lebrador.canWalk();
        System.out.println("Dog can sleep: " + lebrador.canSleep());

        System.out.println("Dog has cells: " + Mammals.hasCells()); // static methods are NOT inherited by implementing class, must use interface name
    }
}
