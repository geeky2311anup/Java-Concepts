//upperBounded generic class example
class Print<T extends Number>{ //bounded generic class
    T value;
    public void setValue(T value){
        this.value = value;
    }

}

//Simple Multi Bounded generic class example
interface Readable {
    void read();
}

interface Writable {
    void write();
}

// Multi-bound generic: T must extend Number AND implement both interfaces
class DataProcessor<T extends Number & Readable & Writable> {
    private T data;
    
    public DataProcessor(T data) {
        this.data = data;
    }
    
    public void processData() {
        System.out.println("Processing number: " + data);
        data.read();   // Can call because T implements Readable
        data.write();  // Can call because T implements Writable
    }
}

// A concrete class that satisfies all bounds
class SmartNumber extends Number implements Readable, Writable {
    private int value;
    
    public SmartNumber(int value) {
        this.value = value;
    }
    
    @Override
    public void read() {
        System.out.println("Reading value: " + value);
    }
    
    @Override
    public void write() {
        System.out.println("Writing value: " + value);
    }
    
    // Required Number class methods
    @Override
    public int intValue() { return value; }
    
    @Override
    public long longValue() { return value; }
    
    @Override
    public float floatValue() { return value; }
    
    @Override
    public double doubleValue() { return value; }
}

//Original complex example (keeping for reference)
interface Read{
    public void ShowObj();
    
}

interface Write{
    String interface2= "Write Interface"; // defining variable in interface is compulsory
    public void ShowObj();

}

class InterfaceChild implements Read, Write{
    @Override
    public void ShowObj(){
        System.out.println("Learning from both interfaces");
    }
}

class MultiBoundGenericClass<T extends Number & Read & Write>{
    T obj;
    
    public void ShowObj(T obj){
        this.obj = obj;
        System.out.println("obj is "+obj);
    }
}

public class BoundedGenerics{
    public static void main(String[] args){
        // Simple upper bound example
        Print<Integer> intObj = new Print<>();
        intObj.setValue(100);
        System.out.println("Integer Value: " + intObj.value);
        
        // Simple multi-bound generic example
        SmartNumber smartNum = new SmartNumber(42);
        DataProcessor<SmartNumber> processor = new DataProcessor<>(smartNum);
        processor.processData();
    }
}