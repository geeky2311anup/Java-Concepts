class RunnableObj implements Runnable {
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    
}
public class RunnableInterface2 {
    public static void main(String[] args){
        RunnableObj runnableObj = new RunnableObj();
        Thread thread1 = new Thread(runnableObj);
        System.out.println(Thread.currentThread().getName());
        thread1.start();
    }
}
