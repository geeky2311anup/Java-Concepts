class MonitorLockExample{
    public  void task1(){
        try{
            System.out.println("inside task1 called by "+Thread.currentThread().getName());
            Thread.sleep(3000);//the threrad which calls this method will sleep for 2 seconds
            System.out.println("end of task1");

        }
        catch(Exception e){
            System.out.println("exception occurred");
        }
    }
}


public class MonitorLock5 {
    public static void main(String[] args){
        MonitorLockExample monitorObj = new MonitorLockExample();
        Thread thread1 = new Thread(() -> {
            monitorObj.task1();
        });
        Thread thread2 = new Thread(() -> {
            monitorObj.task1();
        });
        thread1.start();
        thread2.start();
    }
    
}
//output :
/*
inside task1 called by Thread-0
end of task1
inside task1 called by Thread-1
end of task1

but if we remove synchronized keyword from task1 method then output will be :
inside task1 called by Thread-1
inside task1 called by Thread-0
end of task1
end of task1
 */
