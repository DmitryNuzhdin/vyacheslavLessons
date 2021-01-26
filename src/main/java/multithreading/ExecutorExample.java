package multithreading;

import java.util.concurrent.*;

public class ExecutorExample {
    public static Executor executor = Executors.newFixedThreadPool(10000);

    public static BlockingQueue<String> q = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        q.add("");
        q.peek();


        executor.execute(() -> {
            while (true) {
                System.out.println("1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            while (true) {
                System.out.println("2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(() -> {
            while (true) {
                System.out.println("3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
