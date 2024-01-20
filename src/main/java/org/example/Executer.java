package org.example;

import java.util.concurrent.*;

public class Executer {
    public static void test1() throws ExecutionException, InterruptedException, TimeoutException {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 7,
                1L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(512));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.submit(()-> System.out.println("I am is runnable"));

        Future<Boolean> future = executor.submit(()-> {
            String str = ":)";
            if (":)".equals(str)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        });
        Boolean result = future.get(5,TimeUnit.SECONDS);

        if (result) {
            System.out.println("Ok");
        }
        executor.shutdown();
    }
}
// ThreadPoolExecutor.CallerRunsPolicy() - если нет места в очереди, объектом займется основной поток
// ThreadPoolExecutor.AbortPolicy()- будет выброшен ексепшион
// ThreadPoolExecutor.DiscardOldestPolicy()- "старые" задачи (первые в очереди) будут вытесняться
// ThreadPoolExecutor.DiscardPolicy()- новые задачи будут отклоняться
// https://www.youtube.com/watch?v=pwwmnmWAxg8
