package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {
    static final AtomicInteger i = new AtomicInteger(0);
    static final AtomicReference<String> as = new AtomicReference<>("");

    public static void main(String[] args) {

        as.getAndUpdate(s -> s + "1");


        runNewThread();
        runNewThread();
        runNewThread();
    }

    public static void runNewThread(){
        Runnable runnable = () -> {
            while (true) {
                modifyI();
            }
        };

        new Thread(runnable).start();
    }

    public void a(){
        synchronized (this) {

        }
    }

    public static void modifyI(){
        System.out.println("i = " + i.incrementAndGet());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
