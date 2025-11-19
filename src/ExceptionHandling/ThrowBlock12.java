public class ThrowBlock12 {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            method(-5);
        }
        catch(ClassNotFoundException exceptionObj){
            throw exceptionObj;
        }
}
   public static void method(int val) throws ClassNotFoundException{
        if(val<0){
            throw new ClassNotFoundException();
        }
        else{
            System.out.println("No Exception");
        }
    }
}
