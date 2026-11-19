class MonitorLockExample {

    private final Object fineLock = new Object();

    // Instance lock on 'this' (sleep() keeps the lock)
    public synchronized void task1() {
        try {
            System.out.println(Thread.currentThread().getName() + " entered task1()");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " completed task1()");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    // Unsynchronized method: runs freely without acquiring a monitor lock
    public void task2() {
        System.out.println(Thread.currentThread().getName() + " executing task2()");
    }

    // Synchronized block on 'this': shares instance lock with task1()
    public void task3() {
        System.out.println(Thread.currentThread().getName() + " waiting for task3()");
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + " entered task3()");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " leaving task3()");
            } catch (InterruptedException e) {
                System.out.println("Exception occurred");
            }
        }
    }

    // Class lock on MonitorLockExample.class: independent of 'this'
    public static synchronized void staticTask() {
        try {
            System.out.println(Thread.currentThread().getName() + " entered staticTask()");
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName() + " completed staticTask()");
        } catch (InterruptedException e) {
            System.out.println("Static task interrupted");
        }
    }

    // Dedicated lock object: avoids contention with 'this'
    public void fineGrainedTask() {
        synchronized (fineLock) {
            try {
                System.out.println(Thread.currentThread().getName() + " entered fineGrainedTask()");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " leaving fineGrainedTask()");
            } catch (InterruptedException e) {
                System.out.println("Fine-grained task interrupted");
            }
        }
    }
}

public class MonitorLock5 {

    public static void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        new Thread(obj::task1, "Worker-1").start();
        new Thread(obj::task1, "Worker-2").start();
        new Thread(obj::task2, "Worker-3").start();
        new Thread(obj::task3, "Worker-4").start();
        new Thread(MonitorLockExample::staticTask, "Worker-5").start();
        new Thread(obj::fineGrainedTask, "Worker-6").start();
    }
}