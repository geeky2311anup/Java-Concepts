class ThreadObj extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadClass3 {

    public static void main(String[] args) {

        ThreadObj threadObj = new ThreadObj();

        threadObj.start();

        System.out.println(Thread.currentThread().getName());
    }
}

/*
==========================================================
                WHAT HAPPENS HERE?
==========================================================

1. The JVM starts with the main thread.

   main
    |
    |----> ThreadObj object is created
    |
    |----> threadObj.start()
    |
    |----> main continues
    |
    |----> System.out.println(...)
    |
    |----> main thread finishes
    |
    |----> Thread-0 may execute
    |
    v

==========================================================
WHAT DOES start() ACTUALLY DO?
==========================================================

threadObj.start();

This creates a NEW thread and tells the JVM:

    "This thread is ready to execute."

The JVM will eventually call:

    run()

on the new thread.

IMPORTANT:

start() does NOT mean:

    "Execute run() RIGHT NOW."

The thread has to be scheduled by the JVM/OS.

==========================================================
WHY DOES "main" OFTEN PRINT FIRST?
==========================================================

After:

    threadObj.start();

the main thread is still running.

It immediately reaches:

    System.out.println(Thread.currentThread().getName());

So the main thread may print:

    main

before the newly created thread gets CPU time.

Then Thread-0 executes:

    run()

and prints:

    Thread-0

Output may therefore be:

    main
    Thread-0

==========================================================
BUT CAN Thread-0 PRINT FIRST?
==========================================================

YES!

For example:

    Thread-0
    main

is also a valid output.

Why?

Because thread scheduling is NON-DETERMINISTIC.

The operating system/JVM scheduler decides when each
thread gets CPU time.

==========================================================
IMPORTANT CORRECTION
==========================================================

❌ Don't think:

    "main always runs first because it has higher priority."

That's not guaranteed.

Thread priority and execution order are different things.

Even if one thread has a higher priority, you should NOT
use priority to assume a fixed execution order.

==========================================================
start() vs run()
==========================================================

If you write:

    threadObj.start();

A NEW THREAD is created.

    main
      \
       ---> Thread-0 ---> run()

But if you write:

    threadObj.run();

NO new thread is created.

The main thread itself executes run():

    main ---> run()

Therefore:

    start()  → new thread
    run()    → normal method call

==========================================================
KEY POINT
==========================================================

start()
   ↓
Creates/starts a separate thread
   ↓
JVM schedules it
   ↓
run() executes on that new thread

The order of:

    main
    Thread-0

or:

    Thread-0
    main

is NOT guaranteed.
*/
