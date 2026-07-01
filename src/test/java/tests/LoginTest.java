package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qaway.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginTest {

  WebDriver driver;

  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }

  @Test
  void testLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");

    assertTrue(driver.getCurrentUrl().contains("inventory"));
  }
  @Test
    void testLoginFailed() {
      LoginPage loginPage = new LoginPage(driver);
      loginPage.login("standard_user", "wrong_password");

      String error = loginPage.getErrorMessage();
      assertTrue(error.contains("Username and password do not match"));
  }
  @Test
    void testPageLogo() {
      LoginPage loginPage = new LoginPage(driver);
      String logo_login = loginPage.getTitle();
      assertEquals("Swag Labs",logo_login);
  }

  }