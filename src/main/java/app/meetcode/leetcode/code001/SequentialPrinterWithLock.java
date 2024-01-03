package app.meetcode.leetcode.code001;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class SequentialPrinterWithLock {

    private static final Lock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int number = 1;
    private static final int MAX_NUMBER = 100;

    public void run() {
        Thread oddThread = new Thread(new OddPrinter());
        Thread evenPrinter = new Thread(new EvenPrinter());

        oddThread.start();
        evenPrinter.start();
    }

    class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                lock.lock();
                try {
                    if (number % 2 == 0) {
                        oddCondition.await();
                    }
                    System.out.println(number);
                    number++;
                    evenCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= MAX_NUMBER) {
                lock.lock();
                try {
                    if (number % 2 != 0) {
                        evenCondition.await();
                    }
                    System.out.println(number);
                    number++;
                    oddCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}