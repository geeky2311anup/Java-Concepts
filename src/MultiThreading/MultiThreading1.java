public class MultiThreading1 {

    public static void main(String[] args) {

        Thread current = Thread.currentThread();

        System.out.println("===== Main Thread Information =====");
        System.out.println("Thread Name      : " + current.getName());
        System.out.println("Thread ID        : " + current.getId());
        System.out.println("Thread Priority  : " + current.getPriority());
        System.out.println("Thread State     : " + current.getState());

        System.out.println("\n===== Changing Thread Name =====");

        current.setName("Main-Thread");

        System.out.println("New Thread Name  : " + current.getName());
        System.out.println("Is Alive         : " + current.isAlive());
    }
}
