JAVA STAMPEDLOCK — COMPLETE NOTES (JAVA 8+)

1. WHAT IS STAMPEDLOCK?

StampedLock is a synchronization utility available in
java.util.concurrent.locks, introduced in Java 8.

It protects shared data when multiple threads may read or update it. It
supports three modes:

1.  Optimistic read
2.  Read lock (shared lock)
3.  Write lock (exclusive lock)

Unlike ReentrantReadWriteLock, StampedLock returns a long value called a
“stamp” whenever a lock is acquired. The stamp must be supplied when
validating, converting, or releasing the corresponding lock.

Import: import java.util.concurrent.locks.StampedLock;

2. WHY DO WE NEED IT?

Imagine several threads access a shared bank balance, counter, cache, or
configuration object.

Without synchronization: - Two threads may update shared data at the
same time. - A reader may observe inconsistent data while a writer is
changing it. - Updates can be lost.

StampedLock helps coordinate access: - Multiple readers can hold read
locks simultaneously. - A writer gets exclusive access. - An optimistic
reader can read without initially acquiring a real lock, then validate
whether a writer interfered.

StampedLock can be useful in read-heavy workloads, but it is not
automatically faster in every situation. Benchmark the actual
application before choosing it.

3. THE THREE MODES

A. OPTIMISTIC READ — tryOptimisticRead()

    long stamp = lock.tryOptimisticRead();

-   Does not acquire a real read lock.
-   Usually has low overhead.
-   Does not block a writer.
-   The returned stamp can be zero if a write lock is currently held.
-   Read the required fields into local variables, then call
    validate(stamp).
-   If validation fails, discard the values and read again under a real
    read lock.

Typical pattern:

    long stamp = lock.tryOptimisticRead();
    int localValue = value;

    if (!lock.validate(stamp)) {
        stamp = lock.readLock();
        try {
            localValue = value;
        } finally {
            lock.unlockRead(stamp);
        }
    }

    // Use localValue after obtaining a valid snapshot.

Important: optimistic reading is not the same as locking. Validation
tells you whether the optimistic read remained valid; it does not make
arbitrary unsafe access to mutable object graphs safe. Keep the
read-and-validate section short and follow the API’s memory-consistency
requirements.

B. READ LOCK — readLock()

    long stamp = lock.readLock();
    try {
        // Read shared data safely.
    } finally {
        lock.unlockRead(stamp);
    }

-   This is a real lock.
-   Multiple readers may hold it at the same time.
-   A writer cannot acquire the write lock while readers hold read
    locks.
-   Always release the lock in a finally block.

C. WRITE LOCK — writeLock()

    long stamp = lock.writeLock();
    try {
        // Modify shared data.
    } finally {
        lock.unlockWrite(stamp);
    }

-   This is an exclusive lock.
-   Only one writer can hold it.
-   Readers and other writers are blocked while it is held.
-   Keep the critical section short; avoid slow I/O or long waits while
    holding it.

4. QUICK COMPARISON

Optimistic Read: - Real lock acquired? No. - Blocks writers? No. -
Validation required? Yes. - Suitable for: short reads where concurrent
writes are uncommon.

Read Lock: - Real lock acquired? Yes. - Multiple readers at once? Yes. -
Blocks writers? Yes. - Suitable for: reads that must remain protected
throughout the operation.

Write Lock: - Real lock acquired? Yes. - Multiple writers at once? No. -
Blocks readers? Yes. - Suitable for: modifying shared state.

5. STAMPS AND UNLOCKING

The lock methods return a long stamp:

    long stamp = lock.readLock();
    lock.unlockRead(stamp);

Use the stamp returned by the corresponding acquisition or conversion.
Do not invent a stamp or reuse an old stamp after the lock has been
released.

For read and write locks, use the matching unlock method: -
unlockRead(stamp) - unlockWrite(stamp)

The generic unlock(stamp) method can also release a read or write lock
when appropriate. Optimistic stamps do not represent held locks and are
not unlocked.

6. STAMPEDLOCK IS NOT REENTRANT

StampedLock is not reentrant. A thread must not acquire a second lock in
a way that depends on releasing a lock it already holds.

For example, if a thread holds a write lock and calls another method
that tries to acquire the same StampedLock’s write lock, it may block
forever waiting for itself.

Unlike ReentrantLock, StampedLock does not allow the same thread to
reacquire the lock recursively.

Also, StampedLock does not implement the Lock interface. Its API uses
stamps and its own lock/unlock methods.

7. LOCK CONVERSION

Sometimes a thread holds a read lock and wants to change data.

StampedLock provides conversion methods such as: -
tryConvertToWriteLock(stamp) - tryConvertToReadLock(stamp) -
tryConvertToOptimisticRead(stamp)

Example:

    long stamp = lock.readLock();
    try {
        long writeStamp = lock.tryConvertToWriteLock(stamp);

        if (writeStamp != 0L) {
            stamp = writeStamp;
            // The thread now holds the write lock.
            value++;
        } else {
            // Conversion failed. Release the read lock and retry
            // according to the application's concurrency requirements.
        }
    } finally {
        lock.unlock(stamp);
    }

A non-zero conversion result means conversion succeeded. Zero means it
failed. Do not assume conversion always succeeds. If it fails, decide
whether to retry, release and reacquire, or skip the update. Avoid
waiting indefinitely while holding a read lock if the conversion cannot
succeed.

A simple release-and-reacquire approach can allow another thread to
change the data between the read and the write. If that matters,
re-check the condition after acquiring the write lock.

8. COMPLETE WORKING EXAMPLE

Save as StampedLockDemo.java.

    import java.util.concurrent.locks.StampedLock;

    class SharedResource {
        private int value = 10;
        private final StampedLock lock = new StampedLock();

        public int readOptimistically() {
            long stamp = lock.tryOptimisticRead();
            int result = value;

            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    result = value;
                } finally {
                    lock.unlockRead(stamp);
                }
            }

            return result;
        }

        public int readSafely() {
            long stamp = lock.readLock();
            try {
                return value;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        public void write(int newValue) {
            long stamp = lock.writeLock();
            try {
                value = newValue;
            } finally {
                lock.unlockWrite(stamp);
            }
        }

        public void increment() {
            long stamp = lock.writeLock();
            try {
                value++;
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

    public class StampedLockDemo {
        public static void main(String[] args) throws InterruptedException {
            SharedResource resource = new SharedResource();

            Thread reader1 = new Thread(() ->
                System.out.println("Optimistic read: "
                    + resource.readOptimistically()));

            Thread reader2 = new Thread(() ->
                System.out.println("Locked read: "
                    + resource.readSafely()));

            Thread writer = new Thread(() -> {
                resource.write(50);
                resource.increment();
                System.out.println("Writer finished");
            });

            reader1.start();
            reader2.start();
            writer.start();

            reader1.join();
            reader2.join();
            writer.join();

            System.out.println("Final value: "
                + resource.readSafely());
        }
    }

Notes: - Thread scheduling is nondeterministic, so output order can
vary. - The final value is 51 after the writer completes. - This example
demonstrates the locking patterns; it does not guarantee that the
optimistic read will fail in every run.

9. COMMON MISTAKES

1.  Forgetting to unlock in a finally block.

2.  Calling validate() and ignoring a false result.

3.  Treating an optimistic stamp as if it were a real lock.

4.  Assuming tryConvertToWriteLock() always succeeds.

5.  Acquiring the same StampedLock recursively and causing a deadlock.

6.  Holding a lock while performing slow network or file operations.

7.  Assuming StampedLock is always faster than other synchronization
    tools.

8.  Forgetting that optimistic reads need careful handling of mutable
    state.

9.  Releasing a stamp using the wrong unlock method or using a stale
    stamp.

10. Assuming the order in which threads print messages is fixed.

11. WHEN SHOULD YOU USE IT?

    Consider StampedLock when:

-   Shared state is read much more often than it is written.
-   Optimistic reads can be short and safely validated.
-   You can carefully manage stamps and lock conversion.

Consider synchronized, ReentrantLock, or ReentrantReadWriteLock when: -
Simplicity and maintainability matter more than a possible performance
gain. - Reentrant locking is required. - You need features such as
conditions that StampedLock does not provide directly. - Your access
pattern does not benefit from optimistic reads.

Always measure performance under realistic contention before deciding.

11. INTERVIEW QUESTIONS AND ANSWERS

Q1. What is StampedLock? A. A Java concurrency utility that supports
optimistic reads, shared read locks, and exclusive write locks.

Q2. What is a stamp? A. A long value returned by lock acquisition or
conversion methods. It identifies the lock state/token that must be used
for validation or unlocking.

Q3. What is optimistic reading? A. Reading without acquiring a real read
lock, then validating that a writer did not invalidate the read.

Q4. Why call validate(stamp)? A. To check whether the optimistic read
remained valid. If validation fails, the data read optimistically must
not be trusted as a consistent snapshot.

Q5. What should happen if validation fails? A. Re-read the required data
while holding a read lock, or use another application-appropriate retry
strategy.

Q6. Can multiple readers hold a read lock simultaneously? A. Yes.

Q7. Can multiple writers hold the write lock simultaneously? A. No. The
write lock is exclusive.

Q8. Does a read lock block another reader? A. Normally no; multiple
readers can hold read locks concurrently.

Q9. Does an optimistic read block a writer? A. No. A writer can proceed,
which is why validation is needed.

Q10. Is StampedLock reentrant? A. No.

Q11. Does StampedLock implement java.util.concurrent.locks.Lock? A. No.

Q12. Does tryConvertToWriteLock always succeed? A. No. It returns zero
when conversion cannot be performed.

Q13. Why use finally when unlocking? A. To ensure the lock is released
even if an exception occurs inside the critical section.

Q14. What is the difference between readLock() and tryOptimisticRead()?
A. readLock() acquires a real shared lock and prevents writers from
modifying the protected state while it is held. tryOptimisticRead() does
not acquire a real lock and must be validated.

Q15. Is StampedLock always better than ReentrantReadWriteLock? A.
No. Performance depends on the workload, contention, and access pattern.

Q16. Can a thread acquire a write lock while holding a read lock? A. It
can attempt conversion with tryConvertToWriteLock(). Conversion may
fail; the code must handle that result safely.

Q17. Why should critical sections be short? A. Long-held locks increase
contention and can delay other threads.

Q18. What is a common use case? A. A read-heavy shared object, such as a
frequently read coordinate, configuration value, or cache metadata,
where optimistic reads are appropriate.

12. SUMMARY

-   StampedLock has three modes: optimistic read, read lock, and write
    lock.
-   readLock() allows multiple readers but blocks writers.
-   writeLock() is exclusive.
-   tryOptimisticRead() does not acquire a real lock; validate its
    stamp.
-   If optimistic validation fails, re-read safely.
-   Lock conversion is an attempt, not a guarantee.
-   StampedLock is not reentrant and does not implement Lock.
-   Always release real locks in finally blocks.
-   Choose it based on the use case and measured performance.
