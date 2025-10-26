//three ways of implementing functional interface
//1. by creating a class that implements the interface
interface LivingThings{           //functional interface
    public void canBreathe();      //abstract method
}

class carnivore implements LivingThings{
    @Override
    public void canBreathe(){
        System.out.println("Carnivore can breathe");
    }
}

//2. by using anonymous class
class AnonymousClassExample{
    

static LivingThings HervivoreObject = new LivingThings(){
    @Override
    public void canBreathe(){
        System.out.println("Hervivore can breathe");
    }   
};
}

//3. by using lambda expression
class LambdaExpressionExample{
    

static LivingThings OmnivoreObject = ()->{
    System.out.println("Omnivore can breathe");
};
}
 public class LambdaExpression{
    public static void main(String[] args){
        //1. by creating a class that implements the interface
        carnivore tiger = new carnivore();
        tiger.canBreathe();

        //2. by using anonymous class
        AnonymousClassExample.HervivoreObject.canBreathe();

        //3. by using lambda expression
        LambdaExpressionExample.OmnivoreObject.canBreathe();
    }
}   