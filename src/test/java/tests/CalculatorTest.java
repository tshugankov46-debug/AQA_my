package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  @Test
  void testAddition() {
    int result = 2 + 2;
    assertEquals(4, result);
  }

  @Test
  void testSubtraction() {
    int result = 10 - 3;
    assertEquals(7, result);
  }

  @Test
  void testFailing() {
    int result = 2 + 2;
    assertEquals(5, result); // этот тест упадёт специально
  }
}