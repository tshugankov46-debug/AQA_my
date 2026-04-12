package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {

  @Test
  void firstTestShouldPass() {
    int a = 2;
    int b = 2;
    Assertions.assertEquals(4, a + b, "2 + 2 должно равняться 4");
    System.out.println("Первый тест прошел!");
  }

  @Test
  void secondTestShouldFail() {
    String expected = "Hello";
    String actual = "World";
    Assertions.assertEquals(expected, actual, "Строки не совпадают");
  }
}