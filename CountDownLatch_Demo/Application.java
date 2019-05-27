package CountDownLatch_Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Application {

    private CountDownLatch latch;

    public void startUp() throws Exception {

        latch = new CountDownLatch(2);

        List<Service> services = new ArrayList<>();
        services.add(new HealthCheckerService(latch));
        services.add(new DatabaseCheckerService(latch));

        Executor executor = Executors.newFixedThreadPool(services.size());

        for (Service service: services) {
            executor.execute(service);
        }

        latch.await();

        System.out.println("All services start up");
    }

    public static void main(String[] args) {
        try {
            new Application().startUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
