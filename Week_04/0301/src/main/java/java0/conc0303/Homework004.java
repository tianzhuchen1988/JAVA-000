package java0.conc0303;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * 使用阻塞队列获取执行结果
 *
 * @author chentz
 * @version v1.0
 * @date 2020/11/11 10:34
 */
public class Homework004 {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                arrayBlockingQueue.put(sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();

        System.out.println("异步计算结果为："+ arrayBlockingQueue.take());
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
