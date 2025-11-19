//Generally repeatable are not used alone, they are used with @Repeatable annotation

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.util.Arrays;


@Repeatable(CategoryContainer.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Category{
    String type();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface CategoryContainer{
    Category[] value();
}


@Category(type = "Flying animals")
@Category(type = "Pet animals")
class Bird{
    void display(){
        System.out.println("This is a Bird class");
    }
}

public class RepeatableAnnotation11 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.display();
        Category[] categories = Bird.class.getAnnotationsByType(Category.class);
        System.out.println("Categories:");
        Arrays.stream(categories).forEach(cat -> System.out.println(cat.type()));
    }
}




