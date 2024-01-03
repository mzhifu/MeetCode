package app.meetcode.leetcode.code002;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JavaUpdateTest {

    @Resource
    private JavaUpdate javaUpdate;

    @Test
    void java9Update() {
    }
    @Test
    void java10Update() {
        javaUpdate.java10Update();
    }

    @Test
    void java11Update() {
    }

    @Test
    void java12Update() {
        int result = javaUpdate.java12Update("9");


    }

    @Test
    void java13Update() {
    }

    @Test
    void java14Update() {
    }

    @Test
    void java15Update() {
    }

    @Test
    void java16Update() {
    }

    @Test
    void java17Update() {
    }

    @Test
    void java18Update() {
    }

    @Test
    void java19Update() {
    }

    @Test
    void java20Update() {
    }

    @Test
    void java21Update() {
    }
}