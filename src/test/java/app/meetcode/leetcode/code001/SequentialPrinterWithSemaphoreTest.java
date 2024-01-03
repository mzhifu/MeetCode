package app.meetcode.leetcode.code001;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SequentialPrinterWithSemaphoreTest {

    @Resource
    private SequentialPrinterWithSemaphore sequentialPrinterWithSemaphore;
    @Test
    void run() {
        sequentialPrinterWithSemaphore.run();
    }

    @Test
    void run2() {
        String test = """
                sekect  test, name, gender, age
                """;
        System.out.println(test);

        Person p = new Person(test, "");
        System.out.println(p.toString());
    }

    record Person(String firstName, String lastName) {}
}