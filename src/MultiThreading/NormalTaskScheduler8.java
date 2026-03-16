public class NormalTaskScheduler8 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println('A'+" "+i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println('B'+" "+i);
            }
        });
        thread1.start();//task scheduler will switch between these two threads
        thread2.start();//each thread is running for few milliseconds and then task scheduler will switch to other thread
                        // when switching the earlier task will be in waiting state and when it gets CPU time again it will resume from where it left

    }
}
