import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE) // only in source; not in .class; not visible at runtime
@interface RetentionAnnotation {}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) // retained in .class and visible at runtime
@interface RetentionAnnotation2 {}

class DemoRetention {
    @RetentionAnnotation
    public void demoMethod() {
        System.out.println("This is a demo method with RetentionAnnotation");
    }
}

@RetentionAnnotation2
class AnotherDemoRetention {
    public void anotherDemoMethod() {
        System.out.println("This is another demo method in a class with RetentionAnnotation2");
    }
}

public class RetentionAnnotation8 {
    public static void main(String[] args) {
        DemoRetention demo = new DemoRetention();
        demo.demoMethod();

        AnotherDemoRetention other = new AnotherDemoRetention();
        other.anotherDemoMethod();

        // Read runtime annotation from the class:
        RetentionAnnotation2 ann =
            other.getClass().getAnnotation(RetentionAnnotation2.class);
        System.out.println("Has RetentionAnnotation2? " + (ann != null));
    }
}
