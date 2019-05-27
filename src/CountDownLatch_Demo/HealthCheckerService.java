package CountDownLatch_Demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HealthCheckerService extends Service {

    public HealthCheckerService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            TimeUnit.SECONDS.sleep(2); // wrapper function for Thread.sleep()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
