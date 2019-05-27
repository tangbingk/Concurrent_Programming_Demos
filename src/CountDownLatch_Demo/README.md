## 简介

`CountDownLatch` 也叫闭锁，在JDK1.5被引入，允许一个或多个线程等待其他线程完成操作后再执行。

CountDownLatch 内部会维护一个初始值为线程数量的计数器，主线程执行await方法，如果计数器大于0，则阻塞等待。当一个线程完成任务后，计数器值减1。当计数器为0时，表示所有的线程已经完成任务，等待的主线程被唤醒继续执行。

![](http://ww3.sinaimg.cn/large/006tNc79ly1g3gaaadjhaj30xa0tean9.jpg)

## 应用场景

应用程序的主线程希望在负责启动框架服务的线程已经完成之后再执行。在例子中，模拟了一个应用的启动类，具体实现如下:

Service.java：所有服务的基类，具体实现在execute方法实现。

HealthCheckService.java：服务具体实现类，类似的还有DatabaseCheckerService，这里我们使用TimeUnit.SECONDS.sleep模拟长时间的操作。

Application.java：应用启动类，使用线程池执行每个服务的任务。负责初始化闭锁，然后等待，直到所有服务都被检测完。