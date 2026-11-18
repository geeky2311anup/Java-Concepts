class Print<T> {
    public T value; // generic variable
    public Print(T value){//here we can pass any data type in constructor and it will be stored in its original data type
        this.value=value;//unlike generic using type casting where its stored in object type
    }
}

//More than one Generic type example
class Pair<K,V>{
    public K key;
    public V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public void display(){
        System.out.println("key value pairs are "+key+" and "+value);
    }
}

// --- NEW ADDITIONS ---

// 1. Generic Method Example: A utility class with a generic method
class Util {
    public static <T> void printArray(T[] array) {
        System.out.print("Array elements: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// 2. Bounded Type Parameter Example: Restricts T to only subclasses of Number
class NumericBox<T extends Number> {
    public T number;
    public NumericBox(T number) {
        this.number = number;
    }
    public double getDoubleValue() {
        return number.doubleValue();
    }
}

// ---------------------

public class GenericClass{
    public static void main(String[] args){
        Print<Integer> obj1 = new Print<>(100);
        Print<String> obj2 = new Print<>("Anup");
        Print<Integer> obj3 = new Print<>(105);
        
        System.out.println(obj1.value == 105); //it returns false because 100 != 105
        System.out.println(obj2.value == "Anup");//it returns true because "Anup" == "Anup"
        System.out.println(obj3.value);//it returns 105
        
        Pair<String,Integer> objp = new Pair<>("dhanbad",10);
        objp.display(); 

        // Testing new additions
        System.out.println("\n--- Testing Generic Method ---");
        Integer[] intArray = {10, 20, 30, 40};
        String[] strArray = {"Java", "Python", "C++"};
        Util.printArray(intArray);
        Util.printArray(strArray);

        System.out.println("\n--- Testing Bounded Type Parameter ---");
        NumericBox<Integer> intBox = new NumericBox<>(50);
        NumericBox<Double> doubleBox = new NumericBox<>(99.99);
        System.out.println("Integer as double: " + intBox.getDoubleValue());
        System.out.println("Double value: " + doubleBox.getDoubleValue());
        
        // Note: NumericBox<String> strBox = new NumericBox<>("Test"); // Error! String is not a Number
    }
}
