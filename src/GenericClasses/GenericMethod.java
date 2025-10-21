class GenericMethodDemo{
    
    public <T> void display(T value){
        System.out.println(value);
    }
}
class Animal{
    public String type;
    public String note = "this is public data member";
    public Animal(String type){
        this.type = type;
    }
}
public class GenericMethod{
    public static void main(String[] args){
     Animal obj = new Animal("carnivore");
     System.out.println(obj.type);              // 1st Output: "carnivore"
     GenericMethodDemo obj2 = new GenericMethodDemo();
     obj2.display(obj);                         // 2nd Output: "Animal@6d06d69c"

    }
}

/*
 * NOTES ABOUT THE 2ND OUTPUT:
 * 
 * When we call obj2.display(obj), here's what happens:
 * 
 * 1. We pass the entire Animal object 'obj' to the display() method
 * 2. The generic method display(T value) receives this Animal object as 'value'
 * 3. Inside display(), System.out.println(value) is called
 * 4. Since 'value' is an Animal object, Java calls obj.toString() automatically
 * 5. Animal class doesn't override toString(), so it uses Object's default toString()
 * 6. Object.toString() returns: ClassName@HashCodeInHex
 * 7. Result: "Animal@6d06d69c" (where 6d06d69c is the memory hash code)
 * 
 * BREAKDOWN:
 * - Animal = Class name
 * - @ = Separator  
 * - 6d06d69c = Hexadecimal representation of object's hash code
 * 
 * TO GET BETTER OUTPUT:
 * Add toString() method to Animal class:
 * 
 * @Override
 * public String toString() {
 *     return "Animal{type='" + type + "', note='" + note + "'}";
 * }
 * 
 * This would output: "Animal{type='carnivore', note='this is public data member'}"
 * instead of: "Animal@6d06d69c"
 * 
 * GENERIC METHOD BEHAVIOR:
 * - display(T value) can accept any type (Integer, String, Animal, etc.)
 * - When printing objects, it always calls toString()
 * - For primitive wrappers (Integer, String), toString() gives readable output
 * - For custom objects without toString(), you get ClassName@HashCode format
 */