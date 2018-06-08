package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shancm
 * @pachage concurrent
 * @description:
 * @date 2018/6/7
 */
public class CallableDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        /*Tortoise tortoise = new Tortoise(count);
        Thread thread2 = new Thread(tortoise);
        thread2.start();
        Rabbit rabbit = new Rabbit(count);
        Thread thread1 = new Thread(rabbit);
        thread1.start();

        System.out.println("final: "+count.get());*/

        ExecutorService threadPool = new ThreadPoolExecutor(0, 200,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        Tortoise tortoise = new Tortoise(count);
        Rabbit rabbit = new Rabbit(count);
        List<Callable<Boolean>> list = new ArrayList<>();
        list.add(rabbit);
        list.add(tortoise);
        List<Future<Boolean>> futures = threadPool.invokeAll(list);
        /*threadPool.submit(rabbit);
        threadPool.submit(tortoise);*/
        for (Future<Boolean> futureRes : futures) {
            try {
                System.out.println(futureRes.get()+"000");
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("final: " + count.get());
    }
}
/*
class Rabbit implements Runnable{

    private AtomicInteger count;

    public Rabbit(AtomicInteger integer){
        this.count = integer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }

    }
}

class Tortoise implements Runnable{

    private AtomicInteger count;

    public Tortoise(AtomicInteger integer){
        this.count = integer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }

    }
}*/

class Rabbit implements Callable<Boolean> {

    private AtomicInteger count;

    public Rabbit(AtomicInteger integer) {
        this.count = integer;
    }

    @Override
    public Boolean call() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
        return Boolean.TRUE;
    }
}

class Tortoise implements Callable<Boolean> {

    private AtomicInteger count;

    public Tortoise(AtomicInteger integer) {
        this.count = integer;
    }

    @Override
    public Boolean call() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
        return Boolean.TRUE;
    }
}
