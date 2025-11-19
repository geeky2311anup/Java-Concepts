interface Bird {
    public boolean fly();

}
class Eagle implements Bird{
    @Override // its annotation 
    public boolean fly(){
        return true;
    }
}
public class AnnotationBasic1{
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        System.out.println("Can eagle fly? " + eagle.fly());
    }
}
    