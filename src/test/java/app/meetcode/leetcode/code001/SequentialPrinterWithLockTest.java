package app.meetcode.leetcode.code001;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SequentialPrinterWithLockTest {

    @Resource
    private SequentialPrinterWithLock sequentialPrinterWithLock;

    @Test
    void run() {
        sequentialPrinterWithLock.run();
        System.out.println(1);
    }
}