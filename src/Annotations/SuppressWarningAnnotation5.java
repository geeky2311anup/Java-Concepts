class Bird{
    @Deprecated
    public boolean fly(){
        return true;
    }
}
class Eagle extends Bird{
    @Override
    public boolean fly(){
        return false;
    }
}
@SuppressWarnings("all")
public class SuppressWarningAnnotation5 {


    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        System.out.println("Can eagle fly? " + eagle.fly());
    }
}
