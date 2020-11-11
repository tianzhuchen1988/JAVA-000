package java0.conc0303;

import java.util.concurrent.*;

/**
 * 使用countDownLatch获取执行结果
 *
 * @author chentz
 * @version v1.0
 * @date 2020/11/11 10:34
 */
public class Homework003 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(() -> {
            try {
                return sum();
            } finally {
                countDownLatch.countDown();
            }
        });
        executor.shutdown();
        countDownLatch.await();

        System.out.println("异步计算结果为："+ future.get());

    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
