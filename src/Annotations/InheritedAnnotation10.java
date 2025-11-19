// Demonstrates @Inherited: only annotations marked with @Inherited
// are inherited by subclasses (class-level only).

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Inherited;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// NOT inherited
@interface InheritedAnnotation1 {}

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// Inherited by subclasses
@interface InheritedAnnotation2 {}

@InheritedAnnotation1
class ParentClass1 {
    public void display() {
        System.out.println("This is ParentClass1");
    }
}
class ChildClass1 extends ParentClass1 {
    public void show() {
        System.out.println("This is ChildClass1");
    }
}

@InheritedAnnotation2
class ParentClass2 {
    public void display() {
        System.out.println("This is ParentClass2");
    }
}
class ChildClass2 extends ParentClass2 {
    public void show() {
        System.out.println("This is ChildClass2");
    }
}

public class InheritedAnnotation10 {
    public static void main(String[] args) {
        System.out.println(
            ChildClass1.class.isAnnotationPresent(InheritedAnnotation1.class)
        ); // false (not marked @Inherited)
        System.out.println(
            ChildClass2.class.isAnnotationPresent(InheritedAnnotation2.class)
        ); // true (marked @Inherited)
    }
}
