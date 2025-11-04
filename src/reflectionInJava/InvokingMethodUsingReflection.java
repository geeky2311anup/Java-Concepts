import java.lang.reflect.Method;
class Eagle{
    public void fly(int intparam, boolean boolparam, String strparam){
        System.out.println("fly intparam: "+intparam+", boolparam: "+boolparam+", strparam: "+strparam);
    }
    

}

public class InvokingMethodUsingReflection{
    public static void main(String args[]) throws Exception{
         Class EagleClass = Eagle.class;
            Object EagleObject = EagleClass.newInstance();
            Method flyMethod = EagleClass.getMethod("fly", int.class,boolean.class,String.class);
            flyMethod.invoke(EagleObject,10,true,"hello");
    }
}