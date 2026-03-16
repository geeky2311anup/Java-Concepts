import java.util.concurrent.locks.*;
class SharedResource{
    boolean isAvailable = false;
    public void producer(ReadWriteLock rwLock){
        try{
            rwLock.readLock().lock();
            System.out.println("Read Lock acquired by "+Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(8000);

        }
        catch(Exception e){
            System.out.println("Exception in producer method"); 
        }
        finally{
           
            System.out.println("Read Lock released by "+Thread.currentThread().getName());
             rwLock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock rwLock){
   try{
     rwLock.writeLock().lock();
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

     rwLock.writeLock().unlock();

   }     
   
    }
}

public  class ReadWriteLock11{
    public static void main(String[] args){
        SharedResource resObj = new SharedResource();
        ReadWriteLock rwLock  = new  ReentrantReadWriteLock();
        Thread t1 = new Thread(()->{
            resObj.producer(rwLock);
        });
         Thread t2 = new Thread(()->{
            resObj.producer(rwLock);
        });
        //SharedResource resObj2 = new SharedResource();//it write lock should also be used on same shared object for best practice
        Thread t3 = new Thread(()->{
            resObj.consumer(rwLock);
        });
        t1.start();
        t2.start();
        t3.start();

    }
    
}
