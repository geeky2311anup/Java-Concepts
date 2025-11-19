public class MultipleExceptionInOneCatch10 {
    public static void main(String[] args){
        try{
            method1(-10);
        }
        catch(ClassNotFoundException | InterruptedException exceptionObj){
            System.out.println("Exception handled successfully: " + exceptionObj);
        }
    }

    public static void method1(int val)throws ClassNotFoundException, InterruptedException{
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
