import java.util.concurrent.Semaphore;

class SharedResource {
    private boolean isAvailable = false;
    private Semaphore semaphoreObj = new Semaphore(2);

    public void producer() {
        try {
            semaphoreObj.acquire();
            System.out.println(Thread.currentThread().getName()
                    + " acquired permit. Available permits: "
                    + semaphoreObj.availablePermits());

            isAvailable = true;
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()
                    + " releasing permit.");
            semaphoreObj.release();
        }
    }

    public void consumer() {
        try {
            semaphoreObj.acquire();
            System.out.println(Thread.currentThread().getName()
                    + " acquired permit. Available permits: "
                    + semaphoreObj.availablePermits());

            isAvailable = false;
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()
                    + " releasing permit.");
            semaphoreObj.release();
        }
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        // 5 producers
        for (int i = 1; i <= 5; i++) {
            Thread producer = new Thread(
                    () -> resource.producer(),
                    "Producer-" + i);
            producer.start();
        }

        // 5 consumers
        for (int i = 1; i <= 5; i++) {
            Thread consumer = new Thread(
                    () -> resource.consumer(),
                    "Consumer-" + i);
            consumer.start();
        }
    }
}
