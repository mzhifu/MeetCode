package app.meetcode.leetcode.code001;

import cn.hutool.core.thread.ThreadUtil;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class SequentialPrinterWithSemaphore {

    private static final Semaphore oddSemaphore = new Semaphore(1);
    private static final Semaphore evenSemaphore = new Semaphore(0);
    private static int number = 1;
    private static final int MAX_NUMBER = 100;

    public void run() {
        ThreadUtil.execute(() -> {
            while (number <= MAX_NUMBER) {
                try {
                    oddSemaphore.acquire();
                    if (number % 2 == 0) {
                        oddSemaphore.release();
                    } else {
                        System.out.println(number + "\t" + Thread.currentThread().getName());
                        number++;
                        evenSemaphore.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ThreadUtil.execute(() -> {
            while (number <= MAX_NUMBER) {
                try {
                    evenSemaphore.acquire();
                    if (number % 2 != 0) {
                        evenSemaphore.release();
                    } else {
                        System.out.println(number + "\t" + Thread.currentThread().getName());
                        number++;
                        oddSemaphore.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}