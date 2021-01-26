package multithreading;

public class MultithreadingExample {
    static Integer i = 0;

    public static void main(String[] args) {
        runNewThread("t1");
        runNewThread("t2");
        runNewThread("t3");
    }

    public static void runNewThread(String id){
        Runnable runnable = () -> {
            synchronized (MultithreadingExample.class) {
                while (true) {

                    try {
                        MultithreadingExample.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    modifyI(id);
                    MultithreadingExample.class.notify();
                }
            }
        };

        new Thread(runnable).start();
    }

    public void a(){
        synchronized (this) {

        }
    }

    public static void modifyI(String id){
        i = i + 1;
        System.out.println("thread:" + id + " i = " + i);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
