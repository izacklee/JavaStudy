package com.zeroten.javales.day57c_concurrentfuture;

import java.util.concurrent.*;

public class FutureTest {

    private static PrompLogger logger = PrompLogger.getLogger(FutureTest.class);

    static class Task implements Runnable {

        private int taskId;

        public Task(int taskId) {

            this.taskId = taskId;

        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("线程：%s执行任务：%s 完毕",
                    Thread.currentThread().getName(), taskId));
        }
    }

    static class ResultTask implements Callable {

        private int count;

        public ResultTask(int count) {

            this.count = count;

        }

        @Override
        public Object call() throws Exception {

            Thread.sleep(1000);

            if (count<0) throw new IllegalArgumentException("count must > 0");

            return count * count;
        }
    }

    public static void futureResultTest(int count) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new ResultTask(count));

        try {
            int ret = (Integer) future.get();
            logger.info("执行结果：[{}]", ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            logger.error("执行异常");
            e.printStackTrace();
        }

    }

    public static void futureCancelTest() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future future = executorService.submit(new Task(1));

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (future.cancel(true)) {  // 任务完成后取消不掉

            System.out.println("取消成功");

        }

    }

    public static void main(String args[]) {

        futureResultTest(3);

//        futureCancelTest();

    }

}
