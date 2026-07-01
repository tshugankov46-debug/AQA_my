package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestLifecycle {

    String testName;

    @BeforeEach
    void setUp() {
        testName = "Smoke Test"; // выполняется перед каждым тестом
        System.out.println("Начинаем тест: " + testName);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершили тест: " + testName); // выполняется после каждого теста
    }

    @Test
    void testOne() {
        assertEquals(5, 2 + 3);
    }

    @Test
    void testTwo() {
        assertTrue(testName.contains("Smoke"));
    }
}