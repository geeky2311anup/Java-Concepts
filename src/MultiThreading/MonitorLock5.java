class MonitorLockExample {

    // CASE 1: Synchronized Method
    // Only one thread can execute this method
    // using the same object at a time.

    public synchronized void task1() {

        try {
            System.out.println(
                Thread.currentThread().getName()
                + " entered task1()"
            );

            // Sleep for 3 seconds
            // sleep() does NOT release the monitor lock
            Thread.sleep(3000);

            System.out.println(
                Thread.currentThread().getName()
                + " completed task1()"
            );

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    // CASE 2: Normal Method
    // No monitor lock is required.
    // Other threads can execute this method
    // even when task1() holds the object lock.

    public void task2() {

        System.out.println(
            Thread.currentThread().getName()
            + " executing task2()"
        );
    }

    // CASE 3: Synchronized Block
    // Only the code inside synchronized block is locked.

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


// Main class
// File name: MonitorLock5.java

public class MonitorLock5 {

    public static void main(String[] args) {

        // Creating a single shared object
        MonitorLockExample obj = new MonitorLockExample();

        // Thread 1
        Thread t1 = new Thread(() -> {
            obj.task1();
        }, "Worker-1");

        // Thread 2
        Thread t2 = new Thread(() -> {
            obj.task1();
        }, "Worker-2");

        // Thread 3
        Thread t3 = new Thread(() -> {
            obj.task2();
        }, "Worker-3");

        // Thread 4
        Thread t4 = new Thread(() -> {
            obj.task3();
        }, "Worker-4");

        // Starting all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


/*
====================================================
                 MONITOR LOCK
====================================================

1. Every Java object has an internal lock called
   Monitor Lock or Intrinsic Lock.

2. The synchronized keyword uses this monitor lock.

3. If one thread acquires the lock, another thread
   must wait to acquire the same lock.

----------------------------------------------------
CASE 1: SYNCHRONIZED METHOD
----------------------------------------------------

public synchronized void task1()

- Locks the current object (this).
- Only one thread can execute it at a time
  using the same object.
- Worker-1 and Worker-2 share the same lock.

----------------------------------------------------
CASE 2: NORMAL METHOD
----------------------------------------------------

public void task2()

- No monitor lock is required.
- Can execute while another thread holds
  the object's monitor lock.

----------------------------------------------------
CASE 3: SYNCHRONIZED BLOCK
----------------------------------------------------

synchronized(this) {

    // Critical section

}

- Locks only the specified block.
- Uses the current object's monitor lock.
- The lock is released after exiting the block.

----------------------------------------------------
IMPORTANT POINTS
----------------------------------------------------

1. sleep() does NOT release the monitor lock.

2. wait() releases the monitor lock.

3. notify() wakes up one waiting thread.

4. notifyAll() wakes up all waiting threads.

5. Multiple synchronized methods on the same
   object share the same monitor lock.

6. Different objects have different monitor locks.

7. Normal methods do not require monitor locks.

8. Java supports reentrant locking.

====================================================
FINAL CONCLUSION
====================================================

A monitor lock ensures that only one thread at a
time can execute synchronized code protected by
the same object's monitor lock.

====================================================
*/
