package java0.conc0303;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用Callable+Future获取执行结果
 *
 * @author chentz
 * @version v1.0
 * @date 2020/11/11 10:34
 */
public class Homework001 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(Homework001::sum);
        executor.shutdown();

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
