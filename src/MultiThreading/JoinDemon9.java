public class JoinDemon9
 {
    
}
/*

Question is why Stop, Resume, Suspend method are depricated
use of join , thread priority, daemon thgread

answer->
 Nice set of topics—you’ve basically hit all the “real-world threads” interview points in one line 😄
I’ll go part by part.

1️⃣ Why stop(), suspend(), resume() are deprecated
🔴 Thread.stop() – why it’s dangerous

stop() kills a thread immediately, wherever it is.

Problems:

The thread might be holding locks (inside a synchronized block).
If you kill it there:

Locks are released abruptly

Shared data may be half-updated / inconsistent

Other threads reading that data see corrupted state

Finally blocks may not run as expected.

You get random, hard-to-debug bugs.

So Java said: this is too unsafe → deprecated.
👉 Modern way: use cooperative stop:

class MyTask implements Runnable {
    private volatile boolean running = true;

    public void stopTask() {
        running = false;
    }

    public void run() {
        while (running) {
            // do work
            if (Thread.currentThread().isInterrupted()) break;
        }
    }
}


We ask the thread to stop; it decides when to stop safely.

🔴 Thread.suspend() and Thread.resume() – why they’re dangerous

suspend() pauses a thread wherever it is.
resume() tries to continue it.

Main problems:

If you suspend() a thread while it holds a lock, that lock is never released →
all other threads waiting for that lock block forever → deadlock.

If you call resume() on the wrong thread or forget to call it → that thread is stuck forever.

Again: super easy to create unfixable, random deadlocks.

So they were also deprecated.

👉 Modern approach: use higher-level tools:

wait()/notify() on shared objects

BlockingQueue, Semaphore, ReentrantLock, CountDownLatch, etc. (java.util.concurrent)

2️⃣ join() – what it does and when to use it

join() = “wait for this thread to finish”

Example:

Thread worker = new Thread(() -> {
    // some long work
});

worker.start();

// main thread waits for worker to finish
worker.join();

System.out.println("Worker done, now continue in main");


Use cases:

You started some background computation and need the final result before continuing.

You want to ensure all worker threads finish before program exits.

In simple examples: run multiple threads, then join() each to wait for completion.

Variations:

join() – wait indefinitely

join(long millis) – wait at most millis ms

3️⃣ Thread Priority – what it is and why not to rely on it

In Java:

thread.setPriority(1);  // MIN_PRIORITY
thread.setPriority(5);  // NORM_PRIORITY (default)
thread.setPriority(10); // MAX_PRIORITY


Idea: a hint to the scheduler that some threads are “more important”.

Reality:

JVM passes this to the OS scheduler

Different OSes treat priority differently

JVM does NOT guarantee:

that higher priority will always run first

that low-priority threads won’t starve

So, use priority only as a soft hint, never as core logic.

Typical advice:

Most code: just leave default priority

Maybe bump priority for:

UI threads in desktop apps

very time-sensitive tasks (even then: carefully)

4️⃣ Daemon Threads – what they are and when to use them

A daemon thread is a “background helper” that does not prevent the JVM from exiting.

Key behavior:

When all non-daemon (user) threads finish,

JVM kills all daemon threads automatically and exits.

Creating a daemon thread:

Thread t = new Thread(() -> {
    while (true) {
        // background task
    }
});
t.setDaemon(true);  // must call BEFORE start()
t.start();


Examples:

Garbage collector (GC)

Background log flusher

Heartbeat/ping thread

Cache cleaner

⚠️ Important:

If the JVM shuts down, daemon threads are stopped abruptly:

No guarantee finally blocks run

No guarantee resources are cleaned up

So:

DO NOT use daemon threads for critical tasks (e.g., writing final data to DB, saving files).

Use them for “nice to have” background work.

5️⃣ Quick comparison table
Feature / Method	Status	Use Case	Problem / Note
stop()	Deprecated	Force kill a thread	Corrupts shared state, unsafe
suspend() / resume()	Deprecated	Pause / resume thread	Easy deadlocks, unsafe
join()	Recommended	Wait for a thread to finish	Blocks current thread
setPriority()	Use rarely	Hint scheduler for importance	Not portable, no hard guarantee
Daemon thread	Important	Background helpers	Killed automatically when JVM exits
 */