class Animal{
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println(name + " is eating");
    }
    public void sleep(){
        System.out.println(name + " is sleeping");
    }
    public String getName(){
        return name;
    }
}
class Dog extends Animal{
    private String breed;
    public void bark(){
        System.out.println("dog is barking");
    }
    public Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }
}

class Puppy extends Dog{
   private int age;
   public void play(){
    System.out.println("puppy is playing");
   }
   public Puppy(int age, String breed,String name){
    
    super(breed,name);
    //super(name);
    this.age = age;
   }
   

}

public class Inheritance{
    public static void main(String[] args){
        Animal obj= new Dog("jack", "labrador");
        obj.eat();
        obj.sleep();
        System.out.println("name is "+ obj.getName());
    }
}