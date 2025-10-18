//give example for upcasting

class Animal{
    void sound(){
        System.out.println("Animal makes a sound");
    }
    void bark(){
        System.out.println("Animal barks");
    }
}
class Dog extends Animal{
    void sound(){
        System.out.println("dog makes sound");
    }
    void run(){
        System.out.println("dog runs fast");
    }
}

public class Upcasting{
    public static void main(String[] args){
        Animal puppy = new Dog();
        Dog puppy2 = new Dog();
        puppy.sound();
        puppy.bark();
      //  puppy.run(); give error
    }
}
