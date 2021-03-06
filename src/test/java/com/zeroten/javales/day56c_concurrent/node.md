#### 1.线程池面试
   （1）假如提交到线程池中的任务，IO耗时占比是90%，计算耗时占比10%，忽略提交到线程池中的任务数量，在4C8G的
       机器上，理想情况下线程池中创建多少个线程是最优的。
       答：IO不耗cpu（IO密集型 核心线程数设置CPU核心数两倍） 计算耗cpu（cpu密集型） 最优：既不能多也不能少
        // 线程池最优线程数=(1/计算耗时任务占总任务数的百分比)*cpu核心数 
        // 前面的1代表核心数，(1/计算耗时任务占总任务数的百分比)意思是首先计算出1核下线程池最优线程数
        // 然后再乘以cpu实际核心数，结果就得出最终的线程池最优线程数
        （1/0.1）*4=40个 
   （2）假如有一类cpu密集性的任务，没有IO操作，日常的时候只有1个任务，流量高峰会有40个任务，4C8G的机器上，
       使用的线程池，如何设置corePoolSize,maxPoolSize以及BlockingQueue的大小。
       答：日常只有一个任务执行，corePoolSize=1，高峰时有40个任务，但只有4C（核）的机器，对于cpu密集型任务（线程多性能反而低），
       4个线程是最优的，因此理想状态下maxPoolSize=4，最后再看看队列，因为队列满了，max才会被创建，因此，
       可将大小设置成36。那么线程行为如下，第一个任务，创建出core，1个线程；第二个到第37个任务进入到任务队列，此时，
       任务队列已满，第38个任务到第40个任务，创建出max，此时一共4个线程，4个线程同时将队列里的36个任务消费完，一段时间后，
       max-core数量的线程销毁，即销毁3个线程，还剩下1个线程。