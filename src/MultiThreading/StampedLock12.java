import java.util.concurrent.locks.*;
class SharedResource{
    boolean isAvailable = false;
    StampedLock stampobj = new StampedLock();
    public void producer(){
        Long stamp = stampobj.readLock();
        try{
            System.out.println("Read Lock acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);

        }
        catch(Exception e){
            System.out.println("Exception in producer method"); 
        }
        finally{
            System.out.println("Read Lock released by "+Thread.currentThread().getName());
             stampobj.unockRead(stamp);

        }
        }
        public void consumer(){
            long stamp = stampobj.writeLock();
            try{
                System.out.println("write lock acquired by "+ Thread.currentThread().getName());
                isAvailable = false;
            }
            catch(Exception e){
                System.out.println("Exception occured");
            }
            finally{
            
                System.out.println("Write lock released by:"+ Thread.currentThread().getName()+"after 2 sec");
                try{
                    Thread.sleep(2000);
                }
                catch(Exception e){
                    System.out.println("error occured");
                }   
                stampobj.unockWrite(stamp);


        }
    }
}

public class StampedLock12 {
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
