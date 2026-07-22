//to get perticular class Class object
//there are three ways
//1. using forName() method
//2. using getClass() method
//3. using .class syntax

import java.lang.reflect.Modifier;

// class Bird{
//     public void fly(){
//         System.out.println("Bird is flying");
//     }
// }
// //1st
// Class birdClass1 = Class.forName("Bird");

// //2nd
// Class birdClass2 = Bird.class;

// //3rd
// Bird obj = new Bird();
// Class birdClass3 = obj.getClass();

final class Eagle{   //here we have taken final because we have to print it to see the getModifiers
    public String breed;
    private boolean canSwim;
    public void fly(){
        System.out.println("eat");
    }
}

public class reflection{
    public static void main(String [] args){
        Class eagleClass = Eagle.class;
        System.out.println(eagleClass.getName());
        System.out.println(Modifier.toString(eagleClass.getModifiers()));
        
    }
}

