class MonitorLockExample {

    // synchronized method -> only one thread can execute at a time
    public synchronized void task1() {

        try {

            System.out.println(
                Thread.currentThread().getName()
                + " entered task1()"
            );

            // thread sleeps for 3 seconds
            Thread.sleep(3000);

            System.out.println(
                Thread.currentThread().getName()
                + " completed task1()"
            );

        } catch (InterruptedException e) {

            System.out.println("Thread interrupted");
        }
    }

    // normal method -> no lock required
    public void task2() {

        System.out.println(
            Thread.currentThread().getName()
            + " executing task2()"
        );
    }

    // synchronized block example
    public void task3() {

        System.out.println(
            Thread.currentThread().getName()
            + " waiting for synchronized block"
        );

        synchronized (this) {

            System.out.println(
                Thread.currentThread().getName()
                + " entered synchronized block"
            );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception occurred");
            }

            System.out.println(
                Thread.currentThread().getName()
                + " leaving synchronized block"
            );
        }
    }
}

public class MonitorLock5 {

    public static void main(String[] args) {

        MonitorLockExample obj = new MonitorLockExample();

        Thread t1 = new Thread(() -> {
            obj.task1();
        }, "Worker-1");

        Thread t2 = new Thread(() -> {
            obj.task1();
        }, "Worker-2");

        Thread t3 = new Thread(() -> {
            obj.task2();
        }, "Worker-3");

        Thread t4 = new Thread(() -> {
            obj.task3();
        }, "Worker-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/*
==================== MONITOR LOCK ====================

1. Every Java object has an internal lock called:
   -> Monitor Lock / Intrinsic Lock

2. synchronized keyword uses this monitor lock.

3. If one thread acquires the lock,
   other threads must wait until lock is released.

======================================================

CASE 1 : synchronized method

public synchronized void task1()

- Lock is acquired on current object (this).
- Only one thread can execute task1() at a time.

Possible Output:

Worker-1 entered task1()
Worker-3 executing task2()
Worker-1 completed task1()
Worker-2 entered task1()
Worker-2 completed task1()

Explanation:
- Worker-2 waits because Worker-1 already holds lock.
- task2() runs independently because it is NOT synchronized.

======================================================

CASE 2 : without synchronized

public void task1()

Possible Output:

Worker-1 entered task1()
Worker-2 entered task1()
Worker-1 completed task1()
Worker-2 completed task1()

Explanation:
- Both threads execute simultaneously.
- No monitor lock is used.

======================================================

CASE 3 : synchronized block

synchronized(this) {
    // critical section
}

- Only code inside block is locked.
- Better performance than synchronizing whole method.

======================================================

IMPORTANT POINTS

1. sleep() DOES NOT release monitor lock.

2. wait() releases monitor lock.

3. synchronized methods are thread-safe.

4. Multiple synchronized methods on same object
   share same monitor lock.

5. Different objects have different locks.

======================================================
*/
