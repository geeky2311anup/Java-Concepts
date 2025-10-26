interface Bird{
    public void fly();
    default void eat(){
        System.out.println("Bird is eating");
    }
}
interface Hen extends Bird{
    @Override
    default void eat(){
        System.out.println("Hen is eating grains");
    }
}
class chicken implements Hen{
    @Override
    public void fly(){
        System.out.println("Chicken can fly");
    }
}
class parrot implements Bird{
    @Override
    public void fly(){
        System.out.println("Parrot can fly");
    }
}

public class DefaultMethodInInterface{
 public static void main(String[] args){
    parrot p = new parrot();
    p.fly();
    p.eat();   
    chicken c = new chicken(); 
    c.fly();
    c.eat();
 }

}