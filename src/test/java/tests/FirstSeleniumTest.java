package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FirstSeleniumTest {

  WebDriver driver;

  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup(); // автоматически настраивает драйвер
    driver = new ChromeDriver(); // открываем Chrome
    driver.get("https://www.saucedemo.com/"); // переходим на сайт
  }

  @AfterEach
  void tearDown() {
    driver.quit(); // закрываем браузер
  }

  @Test
  void testPageTitle() {
    String title = driver.getTitle();
    assertEquals("Swag Labs", title); // проверяем заголовок страницы
  }
}