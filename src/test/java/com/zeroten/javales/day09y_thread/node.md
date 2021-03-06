### 进程
    1.进程：一个程序中至少有一个进程，一个进程至少有一个线程。
    2.正常情况下，我们创建的线程，都是用户线程。
    3.守护线程，需要我们手动创建。
      （优先级低 在用户线程结束会自动离开 作用：垃圾收集器，释放内存）
    4.线程是通过调用start()方法，准备就绪的状态。
      （获取到锁也是这个状态，没获取到就是在阻塞状态）
    5.线程真正的执行是由虚拟机等有资源空缺了调用run()方法。
        完整的线程周期：新建new -> 准备执行 -> 开始执行 -> 终止
        线程调度：让线程没办法马上执行完，就是阻塞。
    6.线程启动时的顺序，并非执行的顺序。
    7.每一个线程的数据区是独立的。
    8.通过给线程创建构造的方式，给线程传参。
    9.线程传参时，建议给变量一个final，后面会给大家讲线程安全，但是任何
       安全措施都比不是final，注意final是一个固定的值，这个值不要带变量，
       因为不能保证这个变量也是安全的，除非它是一个常量。
    10.在多线程的情况下，会出现什么问题？
        1) 对旧值不可见，从而造成数据重复
        2) 延迟
        3）滞后
        ...
     11.synchronized关键字：线程同步，锁
         synchronized核心是：native调用（本地调用）
        1) 调用方法的线程持锁，持锁时，其他线程进入阻塞状态。
        2) 调用同步方法的线程执行完毕后，释放锁，其它线程开始竞争持锁。
    12.当某个线程持锁，持锁的状态的线程是可运行状态，其他争夺锁的线程是阻塞状态，
        等待持锁的释放锁，然后再次竞争获取锁，依次这么轮回。 
    
    一个程序执行得慢还是快，看什么？
        1.看cpu快不快。
        2.看内存够不够大，内存的传输效率够不够高。
        3.看程序写得怎么样。
        
    分布式是一种架构风格，微服务是一种设计思想。