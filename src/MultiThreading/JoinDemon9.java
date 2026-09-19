public class JoinDemon9 {

}

/*

Question: Why are stop(), suspend(), and resume() deprecated?
Also explain join(), thread priority, and daemon threads.

1. Why stop(), suspend(), resume() are deprecated

---

## Thread.stop()

stop() forcibly terminates a thread immediately.

Problems:

* The thread can be stopped while modifying shared data.
* It may be holding a lock when stopped.
* Shared objects can be left in an inconsistent state.
* It makes synchronization and debugging difficult.

Example problem:

synchronized void update() {
balance -= 100;
// thread is stopped here
balance += 50;
}

The operation may be left incomplete.

Modern approach:
Use a flag or interruption so that the thread can stop cooperatively.

Example:

class Task implements Runnable {
private volatile boolean running = true;

```
public void stopTask() {
    running = false;
}

public void run() {
    while (running) {
        // perform work
    }
}
```

}

volatile is useful here because changes to running
are visible to other threads.

## Thread.suspend()

suspend() pauses a thread at its current point.

The major problem is that the thread may be holding
a lock when it gets suspended.

Example:

synchronized void work() {
// lock acquired

```
// thread gets suspended here
```

}

Another thread may need the same lock and will wait
indefinitely.

This can result in deadlock-like behavior.

## Thread.resume()

resume() was used to continue a suspended thread.

The problem is that suspend() and resume() are not
safe as a synchronization mechanism.

If resume() is called before the thread actually
reaches the suspended state, the program can behave
unexpectedly.

Modern alternatives:

* wait() / notify()
* BlockingQueue
* Semaphore
* CountDownLatch
* ReentrantLock
* ExecutorService

2. join()

---

join() means:

"Wait until this thread finishes."

Example:

Thread worker = new Thread(() -> {
System.out.println("Worker is running");
});

worker.start();

worker.join();

System.out.println("Worker completed");

Here the main thread waits for worker to finish.

Important:
join() blocks the thread that calls join(),
not the thread being joined.

For example:

worker.join();

means the current thread waits for worker.

Common use cases:

* Waiting for background calculations
* Waiting for multiple worker threads
* Making sure threads complete before continuing
* Collecting results produced by worker threads

Different versions:

join()
-> Wait indefinitely

join(long millis)
-> Wait for at most the specified time

Example with multiple threads:

Thread t1 = new Thread(() -> {});
Thread t2 = new Thread(() -> {});

t1.start();
t2.start();

t1.join();
t2.join();

System.out.println("Both threads finished");

3. Thread Priority

---

Java thread priority ranges from 1 to 10.

Thread.MIN_PRIORITY    = 1
Thread.NORM_PRIORITY   = 5
Thread.MAX_PRIORITY    = 10

Example:

Thread t = new Thread(() -> {
System.out.println("Running");
});

t.setPriority(Thread.MAX_PRIORITY);
t.start();

Priority is only a scheduling hint.

A higher-priority thread is NOT guaranteed to execute
before a lower-priority thread.

For example:

t1.setPriority(10);
t2.setPriority(1);

It does NOT mean:

t1 will definitely finish first.

Why?

* JVM scheduling can depend on the operating system.
* Different operating systems handle priorities differently.
* Scheduling is not something application logic should depend on.
* A lower-priority thread may still get CPU time.

Interview point:

Never use thread priority to guarantee program correctness.

Use synchronization and concurrency utilities instead.

4. Daemon Threads

---

A daemon thread is a background thread that does not
prevent the JVM from terminating.

Example:

Thread background = new Thread(() -> {
while (true) {
System.out.println("Background work");
}
});

background.setDaemon(true);
background.start();

Important:

setDaemon(true) must be called BEFORE start().

Once a thread has started, its daemon status cannot
be changed.

When all non-daemon threads finish:

JVM exits
↓
Daemon threads are also terminated

Examples of tasks suitable for daemon threads:

* Background monitoring
* Cache cleanup
* Periodic housekeeping
* Background helper tasks

Do NOT depend on daemon threads for critical work.

For example:

* Important database operations
* Saving important files
* Final transaction processing
* Critical resource cleanup

5. User Thread vs Daemon Thread

---

User thread:

* Keeps the JVM alive.
* JVM waits for user threads to finish.

Daemon thread:

* Does not keep the JVM alive.
* JVM can exit when no user threads remain.

Example:

Thread userThread = new Thread(() -> {
System.out.println("User thread");
});

Thread daemonThread = new Thread(() -> {
while (true) {
// background work
}
});

daemonThread.setDaemon(true);

userThread.start();
daemonThread.start();

If userThread finishes and no other user threads exist,
the JVM can terminate even though daemonThread is still running.

6. Important Interview Difference

---

stop()
-> Terminates a thread forcibly.

interrupt()
-> Requests a thread to stop/wake from certain blocking
operations. It does not forcibly kill the thread.

suspend()
-> Pauses a thread.

resume()
-> Attempts to continue a suspended thread.

join()
-> Makes the current thread wait for another thread.

setPriority()
-> Gives a scheduling hint.

setDaemon()
-> Marks a thread as a background daemon thread.

7. interrupt() vs stop()

---

This is a common interview question.

stop():

Thread t = new Thread(() -> {
// work
});

t.start();
t.stop();

The thread is forcibly terminated.

interrupt():

Thread t = new Thread(() -> {
while (!Thread.currentThread().isInterrupted()) {
// work
}
});

t.start();
t.interrupt();

Here the thread receives an interruption request and
can decide how to terminate safely.

Therefore, interruption is generally preferred over
forcibly stopping a thread.

8. Important Rule About Daemon Threads

---

Daemon status must be set before starting the thread.

Correct:

Thread t = new Thread(() -> {
// work
});

t.setDaemon(true);
t.start();

Incorrect:

Thread t = new Thread(() -> {
// work
});

t.start();
t.setDaemon(true);

The second approach throws IllegalThreadStateException.

9. Quick Interview Table

---

Feature          Meaning                         Important Point

stop()           Forcefully terminates thread    Deprecated / unsafe

suspend()        Pauses thread                   Deprecated / unsafe

resume()         Continues suspended thread      Deprecated / unsafe

join()           Waits for another thread        Blocks caller

interrupt()      Requests interruption            Cooperative mechanism

setPriority()    Sets scheduling priority        Only a hint

setDaemon()      Makes background thread          Set before start()

10. One-Line Revision

---

stop()
-> Force stop, unsafe

suspend()
-> Pause thread, unsafe

resume()
-> Resume suspended thread, unsafe

join()
-> Wait for another thread

interrupt()
-> Request interruption

Priority
-> Scheduler hint, not a guarantee

Daemon
-> Background thread that doesn't keep JVM alive

Most important interview point:

"Do not depend on deprecated thread-control methods
for synchronization. Prefer cooperative interruption
and java.util.concurrent utilities."
*/
