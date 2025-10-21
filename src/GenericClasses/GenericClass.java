class Print<T> {
    public T value; // generic variable
    public Print(T value){//here we can pass any data type in constructor and it will be stored in its original data type
        this.value=value;//unlike generic using type casting where its stored in object type
    }

}

//More than onr Generic type example
class  Pair<K,V>{
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

public class GenericClass{
    public static void main(String[] args){
        Print<Integer>obj1 = new Print(100);
        Print<String> obj2 = new Print("Anup");
        Print<Integer>obj3 = new Print(105);
        System.out.println(obj1.value == 105); //it returns false because 100 != 105
        System.out.println(obj2.value == "Anup");//it returns true because "Anup" == "Anup"
        System.out.println(obj3.value);//it returns 105
        Pair<String,Integer> objp = new Pair<>("dhanbad",10);
        objp.display(); 

    }
}