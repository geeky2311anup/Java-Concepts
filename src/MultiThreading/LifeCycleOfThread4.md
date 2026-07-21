# 🔥 Java Thread Lifecycle (Complete Notes)

## Thread Lifecycle

Java provides **6 official thread states** (`Thread.State`):

```text
NEW → RUNNABLE → (Running by CPU)
            ↓
 BLOCKED / WAITING / TIMED_WAITING
            ↓
        RUNNABLE
            ↓
      TERMINATED
```

> **Note:** Java **does not officially have a RUNNING state**. A thread that is actually executing is still reported as **RUNNABLE**. We use **RUNNING** only as a conceptual state.

---

# 1️⃣ NEW State

## ✔ Meaning

* Thread object is created.
* `start()` has **not** been called.
* Thread exists only as an object in memory.

## ✔ Example

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running...");
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();   // NEW state
    }
}
```

---

# 2️⃣ RUNNABLE State

## ✔ Meaning

The thread is ready to execute.

It may be:

* Waiting for CPU scheduling
* Or currently executing

Both situations are represented by **RUNNABLE**.

## ✔ Example

```java
MyThread t = new MyThread();
t.start();      // RUNNABLE
```

### Important

Calling `start()` **does not immediately execute `run()`**.

It simply tells the JVM:

> "This thread is ready. Run it whenever the CPU schedules it."

---

# 3️⃣ RUNNING (Conceptual)

## ✔ Meaning

The CPU is currently executing the thread.

Java still reports this state as **RUNNABLE**, but conceptually we call it **RUNNING**.

## ✔ Example

```java
class MyThread extends Thread {
    public void run() {
        System.out.println(
            "Thread is running : " +
            Thread.currentThread().getName()
        );
    }
}
```

When the CPU schedules the thread, `run()` starts executing.

---

# 4️⃣ BLOCKED State

## ✔ Meaning

A thread is waiting to acquire a **monitor lock** (`synchronized` lock).

It cannot continue until another thread releases that lock.

## ✔ Example

```java
class Shared {

    public synchronized void test() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {}

    }
}

class MyThread extends Thread {

    Shared s;

    MyThread(Shared s) {
        this.s = s;
    }

    public void run() {
        s.test();
    }
}

public class Demo {

    public static void main(String[] args) {

        Shared obj = new Shared();

        Thread t1 = new MyThread(obj);
        Thread t2 = new MyThread(obj);

        t1.start();
        t2.start();     // t2 becomes BLOCKED

    }
}
```

## Why does t2 become BLOCKED?

Both threads use the **same object**.

```
t1.s -----> obj
t2.s -----> obj
```

Both call

```java
obj.test();
```

Since `test()` is synchronized:

```
t1 acquires lock
↓

t2 tries to acquire lock
↓

Lock already taken
↓

t2 becomes BLOCKED
```

---

## What if synchronized is removed?

```java
public void test() {

    try {
        Thread.sleep(3000);
    } catch(Exception e){}

}
```

Now there is **no lock**.

```
t1 executes

t2 also executes

Both run simultaneously.
```

No thread becomes BLOCKED.

---

# Understanding synchronized

```java
synchronized(lockObj) {

    // critical section

}
```

This means:

1. Check whether `lockObj` is free.
2. If free → enter the block.
3. If busy → wait.
4. When the current thread exits the block, the lock is released.
5. One waiting thread acquires the lock and continues.

### Visual

```
Thread 1
      |
      | lock free
      V
 Enters synchronized block

Thread 2
      |
      | lock busy
      V
   BLOCKED

Thread 1 finishes
      |
 Releases lock
      |
Thread 2 enters
```

### Important Points

* Only **one thread** can own a particular lock at a time.
* The lock belongs to the object passed to `synchronized`.
* Multiple threads may reach the synchronized block, but only one enters at a time.
* Different lock objects do **not** block each other.

Example:

```java
synchronized(lock1)
```

uses lock of `lock1`.

```java
synchronized(lock2)
```

uses lock of `lock2`.

These are different locks.

---

# BLOCKED vs WAITING

Many students confuse these.

### BLOCKED

Waiting for a synchronized lock.

Needs:

```
Lock becomes available.
```

---

### WAITING

Waiting for another thread to wake it.

Needs:

```
notify()

or

notifyAll()
```

---

# 5️⃣ WAITING State

## ✔ Meaning

Thread waits indefinitely until another thread wakes it.

Occurs with:

* `wait()`
* `join()`
* `LockSupport.park()`

## ✔ Example

```java
class MyThread extends Thread {

    Object lock;

    MyThread(Object lock) {
        this.lock = lock;
    }

    public void run() {

        synchronized(lock) {

            System.out.println("Thread entering WAITING state");

            try {
                lock.wait();
            }
            catch(Exception e){}

            System.out.println("Thread resumed");

        }
    }
}

public class Demo {

    public static void main(String[] args) throws Exception {

        Object lock = new Object();

        MyThread t = new MyThread(lock);

        t.start();

        Thread.sleep(2000);

        synchronized(lock) {

            System.out.println("Main thread sends notify");

            lock.notify();

        }
    }
}
```

### Important

`wait()` releases the lock while waiting.

That allows another thread to enter the synchronized block and call `notify()`.

---

# sleep() vs wait()

| sleep()                   | wait()                        |
| ------------------------- | ----------------------------- |
| Belongs to Thread class   | Belongs to Object class       |
| Does **not** release lock | Releases lock                 |
| Uses timeout              | Waits for notify() or timeout |
| TIMED_WAITING             | WAITING or TIMED_WAITING      |

---

# 6️⃣ TIMED_WAITING

## ✔ Meaning

Thread waits for a fixed amount of time.

After the timeout expires, it automatically becomes RUNNABLE.

Occurs with:

* `Thread.sleep()`
* `wait(timeout)`
* `join(timeout)`
* `parkNanos()`
* `parkUntil()`

## ✔ Example

```java
Thread t = new Thread(() -> {

    try {

        Thread.sleep(3000);

    }
    catch(Exception e){}

});

t.start();
```

During those 3 seconds:

```
TIMED_WAITING
```

### Important

Unlike `wait()`, `sleep()` **does not release the synchronized lock**.

---

# 7️⃣ TERMINATED State

## ✔ Meaning

The thread has completed execution.

Once terminated, it cannot be restarted.

Calling `start()` again throws:

```
IllegalThreadStateException
```

## ✔ Example

```java
Thread t = new Thread(() -> {

    System.out.println("Done");

});

t.start();

t.join();

System.out.println(t.getState());
```

Output

```
TERMINATED
```

---

# Complete Summary

| State                      | Trigger                                     | Leaves State When                                          |
| -------------------------- | ------------------------------------------- | ---------------------------------------------------------- |
| **NEW**                    | `new Thread()`                              | `start()` is called                                        |
| **RUNNABLE**               | `start()`                                   | CPU schedules it or it waits for an event                  |
| **RUNNING** *(Conceptual)* | CPU executes `run()`                        | Time slice ends, blocks, waits, or finishes                |
| **BLOCKED**                | Waiting for synchronized lock               | Lock becomes available                                     |
| **WAITING**                | `wait()`, `join()`, `park()`                | `notify()`, `notifyAll()`, thread completes, or `unpark()` |
| **TIMED_WAITING**          | `sleep()`, `wait(timeout)`, `join(timeout)` | Timeout expires or notification occurs                     |
| **TERMINATED**             | `run()` completes                           | Final state (cannot restart)                               |

---

# Easy Memory Trick

* **NEW** → Thread created.
* **RUNNABLE** → Ready to run (or running).
* **RUNNING** → CPU is executing the thread (concept only).
* **BLOCKED** → Waiting for a **lock**.
* **WAITING** → Waiting for a **signal** (`notify()` or thread completion).
* **TIMED_WAITING** → Waiting for a **fixed time**.
* **TERMINATED** → Thread has finished forever.
