package CountDownLatch_Demo;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {

    private CountDownLatch latch;

    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            execute();
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public void execute() {

    }
}
