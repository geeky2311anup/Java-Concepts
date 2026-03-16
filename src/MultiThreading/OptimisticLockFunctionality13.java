import java.util.concurrent.locks.*;
class SharedResource {
    int a=10;
    StampedLock  stampobj = new StampedLock();
    public void producer(){
        long stamp = stampobj.tryOptimisticRead();
        try{
            System.out.println("taken optimistic lock by "+Thread.currentThread().getName());
            a=20;
            Thread.sleep(8000);
            if(stampobj.validate(stamp)){
                System.out.println("output the value successfully "+a);

            }
            else{
                System.out.println("rollback to work");
                a=10;//rollback
            }
        }
        catch(Exception e){
            System.out.println("Exception in producer method"); 
        }
        
    }
    public void consumer(){
        long stamp = stampobj.writeLock();
        System.out.println("write lock acquired by "+ Thread.currentThread().getName());
        try{
            System.out.println("performing write operation");
            a=9;

        }
       finally{
    
        System.out.println("Write lock released by:"+ Thread.currentThread().getName()+"after 2 sec");
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            System.out.println("error occured");
        }   
        stampobj.unlockWrite(stamp);    
    }
}
}
public class OptimisticLockFunctionality13 {
    public static void main(String[] args){
        SharedResource resObj = new SharedResource();
        Thread t1 = new Thread(()->{
            resObj.producer();
        });
         Thread t2 = new Thread(()->{
            resObj.producer();
        });
        //SharedResource resObj2 = new SharedResource();//it write lock should also be used on same shared object for best practice
        Thread t3 = new Thread(()->{
            resObj.consumer();
        });

        t1.start();
        t2.start();
        t3.start();

    }   
    
}
