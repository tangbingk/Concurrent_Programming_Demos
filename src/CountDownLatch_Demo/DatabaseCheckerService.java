package CountDownLatch_Demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DatabaseCheckerService extends Service {

    public DatabaseCheckerService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
