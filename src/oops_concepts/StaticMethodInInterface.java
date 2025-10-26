interface LivingThings{
    static boolean canBreathe(){//static method in interface should have body
        return true;
    }
}
class Animal implements LivingThings{
    //no need to override static method in interface
    public boolean isBreathing(){
        return LivingThings.canBreathe(); //static method of interface can be called by interface name
    }
}
 class Plant implements LivingThings{
    public boolean canBreathe(){
        return false; //this is not overriding static method of interface, this is just a normal method of class Plant
    }                 //if we try to use @Override it will give error
 }
public class StaticMethodInInterface{
    public static void main(String[] args){
        Animal animal = new Animal();
        System.out.println("Animal breathing: " + animal.isBreathing());
        Plant plant = new Plant();
        System.out.println("Plant breathing: " + plant.canBreathe());
        System.out.println(LivingThings.canBreathe()); //static method of interface can be called by interface name
    }
}