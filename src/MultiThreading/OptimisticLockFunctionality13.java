import java.util.concurrent.locks.StampedLock;

class SharedResource {

    private int value = 10;
    private final StampedLock lock = new StampedLock();

    // Optimistic Read
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

        if (lock.validate(stamp)) {
            System.out.println(Thread.currentThread().getName()
                    + " validation success, value = " + currentValue);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " validation failed, data changed");
        }
    }

    // Read Lock
    public void readData() {

        long stamp = lock.readLock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " acquired READ lock");

            Thread.sleep(3000);

            System.out.println(Thread.currentThread().getName()
                    + " reading value = " + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockRead(stamp);
            System.out.println(Thread.currentThread().getName()
                    + " released READ lock");
        }
    }

    // Write Lock
    public void writeData(int newValue) {

        long stamp = lock.writeLock();

        try {
            System.out.println(Thread.currentThread().getName()
                    + " acquired WRITE lock");

            Thread.sleep(2000);

            value = newValue;

            System.out.println(Thread.currentThread().getName()
                    + " updated value to " + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp);
            System.out.println(Thread.currentThread().getName()
                    + " released WRITE lock");
        }
    }

    // Lock Conversion Example
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

public class StampedLockDemo {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(resource::optimisticReader, "OptimisticReader-1");

        Thread t2 = new Thread(() -> resource.writeData(50), "Writer-1");

        Thread t3 = new Thread(resource::readData, "Reader-1");

        Thread t4 = new Thread(resource::readThenWrite, "Converter-1");

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
