package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qaway.pages.CartPage;
import ru.qaway.pages.InventoryPage;
import ru.qaway.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;

public class InventoryTest {

  WebDriver driver;

  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--password-store=basic");
    options.addArguments("--disable-save-password-bubble");
    options.addArguments("--disable-features=PasswordLeakDetection");
    options.addArguments("--incognito");// отключает менеджер паролей
    driver = new ChromeDriver(options);
    driver.get("https://www.saucedemo.com/");
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }


  @Test
  void testPageLogo() {
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    String logo_login = inventoryPage.getTitle();
    assertEquals("Products",logo_login);
  }

  @Test
  void testProductCount(){
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    int count = inventoryPage.getProductCount();
    assertEquals(6,count);
  }
}