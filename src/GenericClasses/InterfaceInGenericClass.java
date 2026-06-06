Example 1: Generic Interface + Generic Class
interface Container<T> {
    void add(T item);
    T get();
}

class Box<T> implements Container<T> {

    private T value;

    public void add(T item) {
        value = item;
    }

    public T get() {
        return value;
    }
}

Usage:

public class Main {
    public static void main(String[] args) {
        Box<String> b = new Box<>();

        b.add("Hello");

        System.out.println(b.get());
    }
}

Output:

Hello
Example 2: Generic Class Implements Interface with Fixed Type
interface Printer<T> {
    void print(T data);
}

class StringPrinter implements Printer<String> {

    public void print(String data) {
        System.out.println(data);
    }
}

Usage:

StringPrinter p = new StringPrinter();
p.print("Java");
Example 3: Generic Interface with Multiple Type Parameters
interface Pair<K, V> {
    K getKey();
    V getValue();
}

class MyPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

Usage:

MyPair<Integer, String> p = new MyPair<>(1, "One");

System.out.println(p.getKey());
System.out.println(p.getValue());
Syntax
interface InterfaceName<T> {
    // methods
}

class ClassName<T> implements InterfaceName<T> {
    // implementation
}
