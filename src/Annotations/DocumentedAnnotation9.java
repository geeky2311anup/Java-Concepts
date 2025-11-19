@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface CustomAnnotation{};

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface CustomAnnotation2{};

class DemoDocumentedAnnotation{
    @CustomAnnotation
    public void demoMethod1(){
        System.out.println("This is demo method 1 with CustomAnnotation");
    }

    @CustomAnnotation2
    public void demoMethod2(){
        System.out.println("This is demo method 2 with CustomAnnotation2");
    }
}
public class DocumentedAnnotation9 {
    public static void main(String[] args) {
        DemoDocumentedAnnotation demo = new DemoDocumentedAnnotation();
        demo.demoMethod1();
        demo.demoMethod2();
    }
}
//the difference between @CustomAnnotation and @CustomAnnotation2 is 
//that @CustomAnnotation2 is marked with @Documented and when javadoc is
// generated for this code, the annotation @CustomAnnotation2 will be included in
// the javadoc for demoMethod2, while @CustomAnnotation will not be included in the 
//javadoc for demoMethod1.
