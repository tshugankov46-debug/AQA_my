package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

  @Test
  void testString1() {
    String str = "Hello World";
    assertTrue(str.contains("World"));
  }

  @Test
  void testString2() {
    String str = "JUnit";
    assertEquals(5, str.length()); // длина строки "JUnit" = 5
  }

  @Test
  void testString3() {
    String str = "Hello";
    assertEquals("HELLO",str.toUpperCase());
  }
}