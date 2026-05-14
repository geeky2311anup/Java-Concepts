import java.util.concurrent.locks.*;

class SharedResource {
    private boolean isAvailable = false;

    // Use Write Lock for modifications
    public void produce(ReadWriteLock rwLock) {
        rwLock.writeLock().lock(); // Modification requires Write Lock
        try {
            System.out.println(Thread.currentThread().getName() + " is producing...");
            isAvailable = true;
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released Write Lock.");
            rwLock.writeLock().unlock();
        }
    }

    // Use Read Lock for checking state
    public void checkStatus(ReadWriteLock rwLock) {
        rwLock.readLock().lock(); // Shared access for reading
        try {
            System.out.println(Thread.currentThread().getName() + " checked status: " + isAvailable);
            Thread.sleep(2000); // Simulate long read
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released Read Lock.");
            rwLock.readLock().unlock();
        }
    }
}
