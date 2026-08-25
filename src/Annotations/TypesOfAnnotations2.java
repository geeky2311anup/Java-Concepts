//two types of Annotations in java 1) predefined 2) user defined or custom annotations
//predefined annotations are of two types 1) used on annotations 2) used on program elements
//used on annotations : @Retention, @Documented, @Target, @Inherited, @Repeatable
//used on program elements : @Override, @Deprecated, @SuppressWarnings, @FunctionalInterface, @SafeVarargs

//1 Depricated annotation
class Mobile {
    @Deprecated
    public void dummyMeythod() {
        System.out.println("This is a dummy method");
    }
}


public class TypesOfAnnotations2 {
    public static void main(String args[]) {
        Mobile mob = new Mobile();
        mob.dummyMeythod();
    }
}
class Mobile {

    @Deprecated
    public void dummyMethod() {
        System.out.println("This is a dummy method");
    }
}

public class TypesOfAnnotations2 {
    public static void main(String args[]) {
        Mobile mob = new Mobile();

        // Compiler may show a warning because the method is deprecated
        mob.dummyMethod();
    }
}
