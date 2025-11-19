class ThreadObj extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadClass3 {
    public static void main(String[] args){
        ThreadObj threadObj = new ThreadObj();
        threadObj.start();
        System.out.println(Thread.currentThread().getName());//this is printed first because main thread has more priority
        
    }
}

/*
 ✅ Why main prints first and THEN Thread-0?

Your code:

ThreadObj threadObj = new ThreadObj();
threadObj.start();
System.out.println(Thread.currentThread().getName());

What happens:

threadObj.start() creates a new thread and asks the JVM to run its run() method.

But start() does NOT run the thread immediately.
It just requests the JVM scheduler:
“When you get time, please run this new thread.”

Immediately after calling start(), the main thread continues and executes:

System.out.println(Thread.currentThread().getName());


This prints something like:

main


Only after that, the CPU scheduler eventually decides to run the new thread, so you see:

Thread-0

🔥 Key Point:

Thread scheduling is non-deterministic
→ The JVM decides when to run the new thread.
→ The main thread usually finishes its next line faster.
 */
