class Animal{
    private String name;
    public void sleep(){
        System.out.println(name + " is sleeping");
    }

}
class cat extends Animal{
    public void meow(){
        System.out.println("cat meows");
    }
}
interface Pet{
    public void play();
  
}
class Horse implements Pet{
    public void graze(){
        System.out.println("horse grazes");
    }
    public void play(){
        System.out.println("horse plays");
    }
    public Horse(){
        
    }
}
public class IsARelationship{
public static void main(String[] args){
    Pet badal = new Horse();
    badal.play();
    
}
}