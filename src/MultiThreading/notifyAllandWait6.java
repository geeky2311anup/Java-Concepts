class SharedResource{
    boolean itemAvailable = false;
    public synchronized void addItem(){
    itemAvailable = true;
    System.out.println("item added by "+Thread.currentThread().getName()+"invoking all waiting threads");
    notifyAll();
}
public synchronized void consumeItem() {
    System.out.println("inside consume item method called by "+Thread.currentThread().getName());
    while(itemAvailable == false){
        try{
            System.out.println("item not available ,"+Thread.currentThread().getName()+" is going to wait");
            wait();
        }
        catch(Exception e){
            System.out.println("exception occurred");
        }
    }
    System.out.println("item consumed by "+Thread.currentThread().getName());
    itemAvailable = false;
}

}
class ProduceTask implements Runnable{
    SharedResource sharedResourceObj;
    public ProduceTask(SharedResource sharedResource){
        this.sharedResourceObj = sharedResource;
    }
    @Override
    public void run(){
        System.out.println("inside produce task run method called by "+Thread.currentThread().getName());
        try{
            Thread.sleep(5000);//simulating some work
        }
        catch(Exception e){
            System.out.println("exception occurred");
        }
        sharedResourceObj.addItem();


}
}

class ConsumeTask implements Runnable{
    SharedResource sharedResourceObj;
    public ConsumeTask(SharedResource sharedResource){
        this.sharedResourceObj = sharedResource;
    }
    @Override
    public void run(){
        System.out.println("inside consume task run method called by "+Thread.currentThread().getName());
        sharedResourceObj.consumeItem();
}   
}

public class notifyAllandWait6 {
    public static void main(String[] args){
        System.out.println("main method started");
        SharedResource sharedResourceObj = new SharedResource();
        //producer thread
        Thread producerThread = new Thread(new ProduceTask(sharedResourceObj));
        //consumer threads  
        Thread consumerThread1 = new Thread(new ConsumeTask(sharedResourceObj));
        //thread is in runnable state
        producerThread.start();
        //adding some delay so that producer thread gets executed first
        consumerThread1.start();
        System.out.println("main method ended");


    }
}
/*
output :
 *main method started
main method ended
inside consume task run method called by Thread-1
inside consume item method called by Thread-1
inside produce task run method called by Thread-0
item not available ,Thread-1 is going to wait
item added by Thread-0invoking all waiting threads
item consumed by Thread-1
✔ Why THIS exact order happens
main thread starts both threads very fast

Prints:

css
Copy code
main method started
main method ended
Thread-1 (consumer) starts slightly earlier than Thread-0 due to scheduler:

Prints:

pgsql
Copy code
inside consume task run method called by Thread-1
inside consume item method called by Thread-1
itemAvailable is false, so:

vbnet
Copy code
item not available ,Thread-1 is going to wait
Then the consumer executes wait() and goes to waiting state.

Thread-0 (producer) runs:

Prints:

pgsql
Copy code
inside produce task run method called by Thread-0
Sleeps 5 seconds.

After sleep:

pgsql
Copy code
item added by Thread-0invoking all waiting threads
Calls notifyAll() → wakes the consumer.

Thread-1 wakes up from wait():

Prints:

csharp
Copy code
item consumed by Thread-1
 */