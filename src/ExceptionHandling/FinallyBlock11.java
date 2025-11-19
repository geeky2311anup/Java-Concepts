public class FinallyBlock11 {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
           method(-3);
        }
        finally{
            System.out.println("This is finally block. It always executes.");
        }
        

    }
    public static void method(int val)throws ClassNotFoundException{
        if(val>0){
            System.out.println("Positive number");
        }
        else{
            throw new ClassNotFoundException();
        }
    }
}

