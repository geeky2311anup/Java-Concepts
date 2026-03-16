import java.util.concurrent.Semaphore;
class SharedResource{
    boolean isAvailable = false;
    Semaphore semaphoreobj = new Semaphore(2);//2 permits indicates 2 threads can access the shared resource at a time
    public void producer(){
        try{
            semaphoreobj.acquire();
            System.out.println("Semaphore acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);
        }
        catch(Exception e){
            System.out.println("Exception in producer method"); 
        }
        finally{
            System.out.println("Semaphore released by "+Thread.currentThread().getName());
             semaphoreobj.release();
        }   
    }
    public void consumer(){
        try{
            semaphoreobj.acquire();
            System.out.println("Semaphore acquired by "+ Thread.currentThread().getName());
            isAvailable = false;
        }
        catch(Exception e){
            System.out.println("Exception occured");
        }
        finally{
        
            System.out.println("Semaphore released by:"+ Thread.currentThread().getName()+"after 2 sec");
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                System.out.println("error occured");
            }   
             semaphoreobj.release();
        }
    }
}
public class SemaphoreLock14 {
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
        Thread t4 = new Thread(()->{
            resObj.consumer();
        });
            Thread t5 = new Thread(()->{
                resObj.consumer();
            });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    
}
