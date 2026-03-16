import java.util.*;
class SharedClass{
      public Queue<Integer> q = new LinkedList<>();
      public synchronized void produce(int val)throws Exception{
          if(q.size()>=10000){ //buffer size is 5
            System.out.println("Queue is full ,Producer is waiting");
            wait();
          }
          q.add(val);
            System.out.println("Produced item :"+val);
            notify();



      }
      public synchronized void consume()throws Exception{
            if(q.size()<=0){
                System.out.println("Queue is empty ,Consumer is waiting");
                wait();
            }
            int val = q.remove();
            System.out.println("Consumed item :"+val);
            notify();   
      }
}

public class ProducerConsumerProblem7{
    public static void main(String[] args) {
        System.out.println("Producer Consumer Problem Example");
        SharedClass sharedObj = new SharedClass();
        Thread ProducerThread = new Thread(()->{
            try{
                for(int i=0;i<10000;i++){

                    sharedObj.produce(i);
                }

            }
            catch(Exception e){
                System.out.println("Exception in Producer Thread");
            }
        });

        Thread ConsumerThread = new Thread(()->{
            try{
                  for(int i=0;i<10000;i++){
                    sharedObj.consume();
                  }
            }
            catch(Exception e){
                System.out.println("Exception in Consumer Thread");

            }
        });

        ProducerThread.start();
        ConsumerThread.start();
    }
}