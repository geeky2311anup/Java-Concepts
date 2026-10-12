/*
 * Java Threads — Full Summary (Beginner to Advanced)
 *
 * Save as: JavaThreadsNotes.java
 *
 * This file is a study guide with runnable examples and comments.
 * Run: javac JavaThreadsNotes.java
 *      java JavaThreadsNotes
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class JavaThreadsNotes {

    public static void main(String[] args) throws InterruptedException {
        basicsExample();
        synchronizedCounterExample();
        volatileStopExample();
        joinExample();
        executorExample();
        callableFutureExample();
        reentrantLockExample();
        virtualThreadExample();
    }

    // 1. Creating a thread by extending Thread.
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread class: " + Thread.currentThread().getName());
        }
    }

    // 2. Creating a task by implementing Runnable.
    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable task: " + Thread.currentThread().getName());
        }
    }

    static void basicsExample() throws InterruptedException {
        System.out.println("\n--- Thread creation ---");

        Thread first = new MyThread();
        first.start(); // Starts a new thread.

        Thread second = new Thread(new MyTask());
        second.start();

        Thread third = new Thread(
            () -> System.out.println("Lambda task: " + Thread.currentThread().getName())
        );
        third.start();

        first.join();
        second.join();
        third.join();

        // Calling run() directly does NOT start a new thread.
        Thread direct = new Thread(
            () -> System.out.println("Direct run() executes on: "
                + Thread.currentThread().getName())
        );
        direct.run();
    }

    // 3. Race conditions and synchronized.
    static class Counter {
        private int count = 0;

        synchronized void increment() {
            count++;
        }

        synchronized int getCount() {
            return count;
        }
    }

    static void synchronizedCounterExample() throws InterruptedException {
        System.out.println("\n--- synchronized counter ---");
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        };

        Thread a = new Thread(task);
        Thread b = new Thread(task);
        a.start();
        b.start();
        a.join();
        b.join();

        System.out.println("Expected count: 200000");
        System.out.println("Actual count:   " + counter.getCount());

        // AtomicInteger is another option for atomic increments.
        AtomicInteger atomicCount = new AtomicInteger();
        atomicCount.incrementAndGet();
        System.out.println("AtomicInteger example: " + atomicCount.get());
    }

    // 4. volatile visibility. volatile does not make count++ atomic.
    static class Worker {
        private volatile boolean running = true;

        void work() {
            while (running) {
                // Do a small unit of work.
            }
            System.out.println("Worker observed stop request.");
        }

        void stop() {
            running = false;
        }
    }

    static void volatileStopExample() throws InterruptedException {
        System.out.println("\n--- volatile stop flag ---");
        Worker worker = new Worker();
        Thread thread = new Thread(worker::work);
        thread.start();

        Thread.sleep(50);
        worker.stop();
        thread.join();
    }

    // 5. join(): wait for another thread to finish.
    static void joinExample() throws InterruptedException {
        System.out.println("\n--- join() ---");

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Worker prints " + i);
            }
        });

        thread.start();
        thread.join();
        System.out.println("Worker completed; main continues.");
    }

    // 6. ExecutorService and thread pools.
    static void executorExample() throws InterruptedException {
        System.out.println("\n--- ExecutorService ---");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> System.out.println(
                "Task " + taskId + " on " + Thread.currentThread().getName()
            ));
        }

        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    // 7. Callable returns a result; Future retrieves it.
    static void callableFutureExample() throws InterruptedException {
        System.out.println("\n--- Callable and Future ---");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(100);
                return 100;
            });

            System.out.println("Task submitted.");
            try {
                System.out.println("Result: " + future.get());
            } catch (ExecutionException e) {
                System.err.println("Task failed: " + e.getCause());
            }
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }

    // 8. ReentrantLock. Always unlock in finally.
    static class LockCounter {
        private int count = 0;
        private final ReentrantLock lock = new ReentrantLock();

        void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        int getCount() {
            lock.lock();
            try {
                return count;
            } finally {
                lock.unlock();
            }
        }
    }

    static void reentrantLockExample() {
        System.out.println("\n--- ReentrantLock ---");
        LockCounter counter = new LockCounter();
        counter.increment();
        System.out.println("Count: " + counter.getCount());
    }

    // 9. Virtual threads require Java 21 or later.
    // This method is called only when the runtime supports virtual threads.
    static void virtualThreadExample() throws InterruptedException {
        System.out.println("\n--- Virtual thread (Java 21+) ---");

        try {
            Thread thread = Thread.class
                .getMethod("startVirtualThread", Runnable.class)
                .invoke(null, (Runnable) () ->
                    System.out.println("Hello from a virtual thread.")
                ) instanceof Thread t ? t : null;

            if (thread != null) {
                thread.join();
            }
        } catch (ReflectiveOperationException e) {
            System.out.println("Virtual threads require Java 21 or later.");
        }
    }
}

/*
 * THEORY NOTES
 *
 * THREAD STATES
 * - NEW: Thread object created; start() has not been called.
 * - RUNNABLE: Ready to run or actively running.
 * - BLOCKED: Waiting to acquire a monitor lock.
 * - WAITING: Waiting indefinitely for another action.
 * - TIMED_WAITING: Waiting for a specified time.
 * - TERMINATED: run() has completed.
 * Java does not expose RUNNING as a separate Thread.State.
 *
 * start() vs run()
 * - start() starts a new thread and eventually invokes run() on it.
 * - Calling run() directly is an ordinary method call.
 * - A Thread instance can be started only once.
 *
 * synchronized
 * - Provides mutual exclusion on the selected monitor.
 * - Also establishes memory visibility between unlock and a later lock
 *   of the same monitor.
 *
 * wait(), notify(), notifyAll()
 * - Must be called while owning the same object's monitor, usually inside
 *   synchronized(lock).
 * - wait() releases that monitor while waiting.
 * - notify() wakes one waiter but does not release the monitor immediately.
 * - notifyAll() wakes all waiters; they must compete to reacquire the lock.
 * - Always check conditions in a while loop, not an if statement, because
 *   spurious wakeups are permitted and conditions may change before reacquiring.
 *
 * sleep(), wait(), join()
 * - sleep() pauses the current thread and does not release held monitors.
 * - wait() releases the monitor on which it is called.
 * - join() waits for another thread to finish; it does not itself release
 *   monitors held by the calling thread.
 *
 * RACE CONDITIONS
 * - count++ is a read-modify-write sequence and is not atomic.
 * - Protect shared mutable data with synchronization, locks, or atomic types.
 *
 * volatile
 * - Provides visibility/order guarantees for a variable.
 * - Does not make compound operations such as count++ atomic.
 *
 * INTERRUPTS
 * - interrupt() requests cooperative cancellation; it does not forcibly kill
 *   a thread.
 * - isInterrupted() checks a thread's status without clearing it.
 * - Thread.interrupted() checks and clears the current thread's status.
 * - InterruptedException usually clears the interrupt status; restore it with
 *   Thread.currentThread().interrupt() when you cannot propagate the exception.
 *
 * DEADLOCK
 * - Can occur when threads hold locks while waiting for locks held by others.
 * - Avoid inconsistent lock ordering and unnecessary nested locks.
 *
 * DAEMON THREADS
 * - The JVM may exit when only daemon threads remain.
 * - Call setDaemon(true) before start().
 *
 * PRIORITY AND YIELD
 * - Priority and yield() do not guarantee execution order or fairness.
 *
 * EXECUTOR SERVICE
 * - Separates task submission from execution and reuses worker threads.
 * - shutdown() accepts no new tasks but lets submitted tasks finish.
 * - shutdownNow() attempts interruption and returns tasks not yet started;
 *   it does not guarantee running tasks will stop.
 *
 * CALLABLE AND FUTURE
 * - Callable can return a value and throw checked exceptions.
 * - Future.get() waits for the result unless already complete.
 *
 * REENTRANTLOCK
 * - Supports tryLock(), timed acquisition, and interruptible acquisition.
 * - Release the lock in finally.
 *
 * JAVA MEMORY MODEL / HAPPENS-BEFORE
 * - Unlocking a monitor happens-before a later lock of the same monitor.
 * - A volatile write happens-before a subsequent read that observes it.
 * - Actions before Thread.start() happen-before actions in the started thread.
 * - Actions in a thread happen-before another thread successfully returns
 *   from joining it.
 *
 * CONCURRENCY VS PARALLELISM
 * - Concurrency: multiple tasks make progress over overlapping periods.
 * - Parallelism: multiple tasks execute at the same instant.
 *
 * DEADLOCK VS STARVATION VS LIVELOCK
 * - Deadlock: threads wait forever on each other's resources.
 * - Starvation: a thread cannot obtain resources or CPU time to progress.
 * - Livelock: threads remain active but do not make useful progress.
 *
 * PRODUCER-CONSUMER
 * - A producer waits while a bounded queue is full.
 * - A consumer waits while the queue is empty.
 * - Check conditions in while loops around wait().
 * - In real applications, java.util.concurrent.BlockingQueue is often safer
 *   and simpler than implementing wait()/notify() manually.
 */
