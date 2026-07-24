// Interface
interface Bird {
    boolean fly();
}

// Eagle class implementing Bird interface
class Eagle implements Bird {

    // @Override tells the compiler that this method
    // is overriding a method from the Bird interface.
    @Override
    public boolean fly() {
        return true;
    }
    

    public void sound() {
        System.out.println("Eagle makes a screeching sound.");
    }
}

// Main class
public class AnnotationBasic1 {

    public static void main(String[] args) {
        Eagle eagle = new Eagle();

        System.out.println("Can eagle fly? " + eagle.fly());
        eagle.sound();
    }
}
