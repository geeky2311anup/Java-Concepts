interface Bird{
    int weight = 5; //by default public static final
    public static final String color = "varied"; //explicitly public static final
    public void fly();
}
interface LivingThings{
    public void canBreathe();
}

interface NonFlyingBird extends Bird, LivingThings{
    public void canRun();
}
class Hen implements NonFlyingBird{
    @Override
    public void fly(){
        System.out.println("it can fly in limit");
    }
    @Override
    public void canBreathe(){
        System.out.println("it can breathe");
    }
    @Override
    public void canRun(){
        System.out.println("it can run");
    }
}

public class Interface_in_deep{
    public static void main(String[] args){
        Hen hen = new Hen();
        hen.fly();
        hen.canBreathe();
        hen.canRun();
        Bird chicken = new Hen();
        chicken.fly();
        //chicken.canBreathe(); //give error because reference type is Bird and it does not have canBreathe() method
        LivingThings livingThing = new Hen();
        livingThing.canBreathe();
        //livingThing.fly(); //give error because reference type is LivingThings and it does not have fly() method
    }
}