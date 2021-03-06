#### 1.信号量（可以用于限制每秒访问数）
  （1）实现一个简单流控程序
      要求：限制TPS（Transactions Per Second 每秒传输的事物处理个数（每秒访问数））为10
          常规思路：
            1）先给一个semaphore一个初始值
            2）先获取permits，能够获取则继续访问，否则等待
            3）线程操作完release许可
          存在问题：
            1）无法严格控制TPS，请求可能会超限（临界点容易出问题，比如在0.01秒或者0.99秒有大量的请求就容易出问题了）
          semaphore实现流控的思路：
            1）后台线程每秒发放固定的permits
            2）业务线程在进行操作前先获取permits
       公平性：如果前面有线程等待，则获取失败也需要等待。
       非公平性：就算前面有线程等待，后面的线程获取的许可数符合，照样可以获取成功。
  （2）拿不到资源就等（放到同步队列里 结合AQS去理解），拿到资源了就继续访问。
  （3）信号量用scheduleAtFixedRate实现的问题：
      1）每做一个接口就得花费一个线程，耗资源。如果只对1-2个接口处理是没问题的，但是对大量接口处理就有问题了。
      2）这种策略每秒发放的资源数固定，要是超了，就只能等待。限制过于严格。

#### 2.HashMap VS ConcurrentHashMap
   HashMap: key的区分，key对象的hashcode和equals方法
    