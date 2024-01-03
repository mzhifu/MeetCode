package app.meetcode.leetcode.code001;

import cn.hutool.core.thread.ThreadUtil;
import org.springframework.stereotype.Component;

@Component
public class SequentialPrinter {

    private static final Object lock = new Object();
    private static int number = 1;
    private static final int MAX_NUMBER = 100;

    public void run() {

        Thread oddThread = new Thread(new OddPrinter());
        Thread evenThread = new Thread(new EvenPrinter());

        oddThread.start();
        evenThread.start();
    }

    class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }
                }
            }
        }
    }

    class EvenPrinter implements Runnable {

        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                synchronized (lock) {
                    if (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }
                }
            }
        }
    }
}