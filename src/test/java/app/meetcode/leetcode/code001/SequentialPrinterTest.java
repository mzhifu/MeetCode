package app.meetcode.leetcode.code001;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class SequentialPrinterTest {

    @Resource
    private SequentialPrinter sequentialPrinter;


    @Test
    void contextLoads() {
        sequentialPrinter.run();
    }
}