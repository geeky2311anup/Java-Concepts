class MyTask extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}

public class Main {
    public static void main(String[] args) {

        MyTask t1 = new MyTask();
        MyTask t2 = new MyTask();

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
