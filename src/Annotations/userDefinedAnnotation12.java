import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//we can create user defined annotations in java using @interface keyword
@Target(ElementType.TYPE) //specifies that this annotation can be applied to class, interface, or enum
@Retention(RetentionPolicy.RUNTIME) //specifies that this annotation will be available at runtime
@interface CustomAnnotation {
    String author();
    String date();
    int version();
}

@CustomAnnotation(
    author = "John Doe",
    date = "2024-10-01",
    version = 1
)
class Democlass{
    public void display(){
        System.out.println("This is a demo class with user defined annotation");
    }
}

public class userDefinedAnnotation12 {
    public static void main(String[] args) {
        Democlass demo = new Democlass();
        //Accessing annotation information at runtime
       System.out.println(Democlass.class.getAnnotation(CustomAnnotation.class));
}
}
