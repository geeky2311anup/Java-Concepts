import java.io.InterruptedIOException;

public class HandelingException9 {
    public static void main(String[] args){
        {
            try{
                method1(-10);
            }
            catch(ClassNotFoundException exceptionObj){
                System.out.println("ClassNotFoundException handled successfully.");
            }
            catch(InterruptedException exceptionObj){
                System.out.println("InterruptedException handled successfully.");
            }

            
        }
}

public static void method1(int val) throws ClassNotFoundException, InterruptedException{
    if(val<0){
        throw new ClassNotFoundException();
    }
    else if(val==0){
        throw new InterruptedException();
    }
    else{
        System.out.println("No Exception");
    }
}
}
