import java.util.concurrent.locks.StampedLock;

/*
===============================================================================
                           STAMPED LOCK (Java 8)
===============================================================================

StampedLock is an advanced synchronization mechanism introduced in Java 8.

It provides three locking modes:

1. Optimistic Read
2. Read Lock
3. Write Lock

Unlike ReentrantReadWriteLock, every lock acquisition returns a long value
called a "stamp".

This stamp represents ownership of the lock and must be supplied while
unlocking.

===============================================================================
Advantages
===============================================================================

✔ Better performance than ReentrantReadWriteLock in read-heavy applications.

✔ Supports Optimistic Reading.

✔ Supports Lock Conversion (Read → Write).

✔ Multiple readers can read simultaneously.

✔ Only one writer can modify data at a time.

===============================================================================
Lock Types
===============================================================================

1. tryOptimisticRead()

    • Doesn't actually lock the object.
    • Returns a stamp.
    • Fastest operation.
    • Must validate before using data.

2. readLock()

    • Acquires an actual read lock.
    • Multiple readers allowed.
    • Blocks writers.

3. writeLock()

    • Exclusive lock.
    • Only one thread allowed.
    • Blocks readers and writers.

===============================================================================
Optimistic Read Flow
===============================================================================

Reader

tryOptimisticRead()

↓

Read Data

↓

validate(stamp)

↓

true  -> Data was unchanged.

false -> Some writer modified data.
         Read again using readLock().

===============================================================================
Read Lock Flow
===============================================================================

Reader

↓

readLock()

↓

Multiple readers can execute together

↓

unlockRead()

===============================================================================
Write Lock Flow
===============================================================================

Writer

↓

writeLock()

↓

Modify shared data

↓

unlockWrite()

===============================================================================
Lock Conversion
===============================================================================

Sometimes a thread starts as a reader but later decides it must write.

Instead of:

Read Lock
↓

Unlock

↓

Acquire Write Lock

(which may allow another thread to modify data)

StampedLock provides

tryConvertToWriteLock()

which upgrades the lock safely.

===============================================================================
Important Points
===============================================================================

• StampedLock is NOT reentrant.

Meaning:

Same thread cannot acquire write lock twice.

Otherwise it may deadlock.

Unlike ReentrantLock.

• Does NOT implement Lock interface.

• Every lock returns a stamp.

• Unlock requires the same stamp.

===============================================================================
Typical Interview Questions
===============================================================================

Q1 Why StampedLock?

Answer:
Better performance for read-heavy applications.

------------------------------------------------

Q2 Difference between Read Lock and Optimistic Read?

Read Lock

✔ Real lock
✔ Blocks writers
✔ Safe

Optimistic Read

✔ No actual lock
✔ Doesn't block writer
✔ Must validate()

------------------------------------------------

Q3 Why validate()?

Because optimistic read does not prevent writers from modifying data.

validate() checks whether data changed while reading.

------------------------------------------------

Q4 What happens if validation fails?

Discard old data.

Acquire readLock()

Read again.

------------------------------------------------

Q5 Can multiple readers execute simultaneously?

YES.

------------------------------------------------

Q6 Can multiple writers execute simultaneously?

NO.

------------------------------------------------

Q7 Is StampedLock reentrant?

NO.

===============================================================================
*/
class SharedResource {

    /*
     Shared variable protected by StampedLock.
    */
    private int value = 10;

    /*
     Every synchronization operation happens through this lock.
    */
    private final StampedLock lock = new StampedLock();

    /*
    ===========================================================================
    OPTIMISTIC READ

    Fastest read.

    No actual locking happens.

    Another thread may modify data while we are reading.

    Therefore validate() is mandatory.
    ===========================================================================
    */
    public void optimisticReader() {

        long stamp = lock.tryOptimisticRead();

        int currentValue = value;

        System.out.println(Thread.currentThread().getName()
                + " acquired optimistic read");

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         validate() returns

         true
             No writer changed the data.

         false
             Writer modified data.
             Read result cannot be trusted.
        */

        if (lock.validate(stamp)) {

            System.out.println(Thread.currentThread().getName()
                    + " validation success, value = "
                    + currentValue);

        } else {

            System.out.println(Thread.currentThread().getName()
                    + " validation failed, data changed");
        }
    }

    /*
    ===========================================================================
    READ LOCK

    Real shared lock.

    Multiple readers allowed.

    Writers blocked.
    ===========================================================================
    */
    public void readData() {

        long stamp = lock.readLock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired READ lock");

            Thread.sleep(3000);

            System.out.println("Reading value = " + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlockRead(stamp);

            System.out.println(Thread.currentThread().getName()
                    + " released READ lock");
        }
    }

    /*
    ===========================================================================
    WRITE LOCK

    Exclusive lock.

    Only one writer.

    No readers allowed while writing.
    ===========================================================================
    */
    public void writeData(int newValue) {

        long stamp = lock.writeLock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired WRITE lock");

            Thread.sleep(2000);

            value = newValue;

            System.out.println("Updated value = " + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlockWrite(stamp);

            System.out.println(Thread.currentThread().getName()
                    + " released WRITE lock");
        }
    }

    /*
    ===========================================================================
    LOCK CONVERSION

    Instead of releasing read lock and acquiring write lock again,
    tryConvertToWriteLock() upgrades it.

    If conversion succeeds:
        returns non-zero stamp.

    If conversion fails:
        returns 0.
    ===========================================================================
    */
    public void readThenWrite() {

        long stamp = lock.readLock();

        try {

            System.out.println(Thread.currentThread().getName()
                    + " acquired READ lock");

            long writeStamp = lock.tryConvertToWriteLock(stamp);

            if (writeStamp != 0L) {

                stamp = writeStamp;

                System.out.println(Thread.currentThread().getName()
                        + " upgraded to WRITE lock");

                value += 100;

                System.out.println("New Value = " + value);

            } else {

                System.out.println("Lock upgrade failed");
            }

        } finally {

            lock.unlock(stamp);
        }
    }
}

/*
===============================================================================
Execution Order

OptimisticReader

↓

Reads value without locking

↓

Writer modifies value

↓

validate()

↓

Fails

↓

Reader knows data changed

-------------------------------------------------------------------------------

Reader

↓

Acquires read lock

↓

Reads safely

↓

Releases lock

-------------------------------------------------------------------------------

Converter

↓

Acquires read lock

↓

Converts to write lock

↓

Updates value

↓

Unlocks

===============================================================================
*/

public class StampedLockDemo {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::optimisticReader,
                "OptimisticReader-1");

        Thread t2 = new Thread(() -> resource.writeData(50),
                "Writer-1");

        Thread t3 = new Thread(resource::readData,
                "Reader-1");

        Thread t4 = new Thread(resource::readThenWrite,
                "Converter-1");

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        t2.start();
        t3.start();
        t4.start();
    }
}
