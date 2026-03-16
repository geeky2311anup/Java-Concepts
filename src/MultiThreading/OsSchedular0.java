🧵 Java Threads — Full Summary (Beginner → Advanced)

(Covers everything we discussed so far)

1️⃣ What is a Thread? (Basics)

A thread is a lightweight unit of execution.
A Java program can have:

Single-threaded execution (one task at a time)

Multi-threaded execution (multiple tasks running “in parallel”)

Threads allow:

Background tasks

Parallel processing

Faster & responsive programs

2️⃣ Thread Lifecycle (All States We Covered)
✔ NEW

Thread object created, start() not called yet

Thread t = new Thread(); // NEW

✔ RUNNABLE

start() called; thread ready to run but not guaranteed to be running

t.start(); // RUNNABLE

✔ RUNNING

OS has given CPU time to this thread.
Java internally treats RUNNABLE and RUNNING as one state.

✔ BLOCKED

Thread waiting to obtain a lock (e.g., synchronized block)

✔ WAITING

Thread waits indefinitely:
wait(), join(), or some locks.

✔ TIMED_WAITING

Thread waits for fixed time:
sleep(2000), wait(3000), join(1000)

✔ TERMINATED

Thread has finished execution.

3️⃣ synchronized Keyword (Very Important)

synchronized(lockObj){ } is not a function.
It is a block that:

Locks on lockObj

Only one thread can enter this block at a time

Others must wait outside

Used to prevent race conditions.

Key rule:
wait(), notify(), notifyAll() must be inside a synchronized block.

4️⃣ wait(), notify(), notifyAll() (Thread Communication)
✔ wait()

Thread releases the lock

Enters WAITING state

Pauses until someone calls notify()

Must be inside synchronized block

✔ notify()

Wakes one waiting thread

Does NOT release lock immediately

Lock is released only AFTER synchronized block ends

✔ notifyAll()

Wakes all waiting threads

They compete for the lock

5️⃣ Producer–Consumer Problem (FULL Understanding)

Why do we need it?

✔ Producer & Consumer run in parallel, not sequentially
✔ They work at different speeds
✔ Queue can become full / empty
✔ One must wait for the other
✔ They take turns naturally (based on queue condition)
✔ Thread switching makes them interleaved

Producer does NOT fill the queue completely,
Consumer does NOT empty it completely,
They switch whenever scheduler decides,
plus they block on queue FULL / EMPTY.

This is how real systems work (streaming, pipelines, servers).

6️⃣ Thread Scheduling Behavior (What You Learned)
✔ Thread scheduler can switch threads anywhere

In the middle of a loop

In the middle of a print statement

In the middle of a method

Doesn’t wait for loop/function to finish

✔ Thread A may run multiple times in a row

YES.
Scheduler can do:

A → A → A → B → B → A → B


There is NO guaranteed fairness.

✔ Time-slice?

The OS, not JVM, decides.
A thread usually runs for a few milliseconds before switching.

✔ Java does NOT guarantee:

Order of execution

Fair switching

Equal time slices

That two threads alternate

7️⃣ Thread Blocking Behavior
A running thread stops when:

Its time slice ends

It calls sleep()

It calls wait()

It calls join()

It’s doing I/O

It’s trying to enter a synchronized block that is locked by another thread

It finishes execution

8️⃣ Key Examples You Understood
✔ synchronized block with lockObj

Locks only the code inside
Does not execute methods of lockObj
lockObj acts as a key, nothing more.

✔ wait/notify example

Producer sleeps when queue is full,
Consumer sleeps when queue is empty,
They wake each other using notify.

✔ For loop inside a thread

Scheduler does NOT wait for loop to finish
Scheduler switches threads multiple times inside loop.

9️⃣ Important Clarifications (Your Doubts Answered)
❓ Does producer fill queue fully?

❌ No — it may fill 2, then consumer removes 1, then producer fills again.

❓ When does consumer run?

Whenever scheduler decides, AND when queue is not empty.

❓ Do they run sequentially?

❌ No — they run in parallel.

❓ Does scheduler wait for loop to finish?

❌ No — it can switch threads during loop.

❓ Can scheduler run same thread many times in a row?

✔ YES.

❓ Does JVM control time-slice?

❌ OS controls it.

❓ Why synchronized?

To prevent multiple threads modifying shared data simultaneously.

🔟 Frequently Asked Interview Questions (Based on Our Discussion)
⭐ Q1: Can scheduler interrupt a thread anytime?

✔ YES.
Even inside loops or print statements.

⭐ Q2: Does producer need to fill queue fully before consumer runs?

❌ No — both run simultaneously.

⭐ Q3: Can one thread run many times before other?

✔ Yes — Java does not guarantee fairness.

⭐ Q4: Does Java guarantee order of thread execution?

❌ No.

⭐ Q5: Why do we need wait/notify?

Because they allow threads to communicate when shared resource is full/empty.

⭐ Q6: Can we call wait() without synchronized?

❌ No → throws IllegalMonitorStateException.

⭐ Q7: What happens if queue is full and producer tries to add?

Producer calls wait() and blocks.

⭐ Q8: What happens if queue is empty and consumer tries to remove?

Consumer calls wait() and blocks.

⭐ Q9: How long does a thread run before switching?

OS-dependent (few milliseconds), NOT fixed.

⭐ Q10: Can yield() guarantee switching?

❌ No — only a hint.

🔥 Final Mental Model (Super Simple)

Threads run in parallel, switching constantly.

Scheduler can stop a thread any time.

Producer & consumer take turns based on queue state.

synchronized controls turn-by-turn access.

wait/notify control blocking/waking.

Java threads depend heavily on OS scheduler.