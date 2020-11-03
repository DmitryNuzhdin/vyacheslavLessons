package WebToDoList.Interfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class AMyInterface implements Runnable, IMyInterface {
    protected ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Override
    public void start() {
        executorService.execute(getRunnable());
    }

    abstract Runnable getRunnable();

//    new Runnable() {
//        @Override
//        public void run() {
//            boolean shutdownFlag = false;
//            while (! shutdownFlag && ! executorService.isShutdown()){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    shutdownFlag = true;
//                }
//            }
//
//        }
//    };

    public void stop(){
        executorService.shutdown();
    }

}
