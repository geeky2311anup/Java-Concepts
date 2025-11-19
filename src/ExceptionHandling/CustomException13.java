class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}

public class CustomException13 {
    public static void main(String [] args) {
        try{
            method(-6);
        }
        catch(MyException ExceptionObj){
            System.out.println("Custom Exception handled: " + ExceptionObj.getMessage());
            System.out.println("Custom Exception handled: " + ExceptionObj);//see how to print exception object
        }
    }

    public static void method(int val) throws MyException{
        if(val<0){
            throw new MyException("Value cannot be negative: " + val);
        }
        else{
            System.out.println("No Exception");
        }
    }   
}
