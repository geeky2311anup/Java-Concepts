interface Bird {
    boolean fly();
}

class Eagle implements Bird {

    @Override
    public boolean fly() {
        return true;
    }

    public void sound() {
        System.out.println("Eagle makes a screeching sound.");
    }
}

public class AnnotationBasic1 {

    public static void main(String[] args) {
        Eagle eagle = new Eagle();

        System.out.println("Can eagle fly? " + eagle.fly());
        eagle.sound();
    }
}