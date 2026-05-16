class RunnableObj implements Runnable {

    private String taskName;

    // Constructor
    RunnableObj(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        // Loop to simulate work
        for (int i = 1; i <= 5; i++) {

            System.out.println(
                "Task: " + taskName +
                " | Count: " + i +
                " | Running Thread: " + Thread.currentThread().getName()
            );

            // Pause thread for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println(taskName + " finished.");
    }
}

public class RunnableInterface2 {

    public static void main(String[] args) {

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        // Create Runnable objects
        RunnableObj task1 = new RunnableObj("Printing Numbers");
        RunnableObj task2 = new RunnableObj("Processing Data");

        // Create Threads
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Set custom thread names
        thread1.setName("Worker-1");
        thread2.setName("Worker-2");

        // Start threads
        thread1.start();
        thread2.start();

        // Main thread work
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                "Main thread working... " + i
            );

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }

        System.out.println("Main thread finished.");
    }
}
