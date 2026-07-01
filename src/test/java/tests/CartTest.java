package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qaway.pages.CartPage;
import ru.qaway.pages.CheckoutPage;
import ru.qaway.pages.InventoryPage;
import ru.qaway.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeOptions;

public class CartTest {
  WebDriver driver;
  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--password-store=basic");
    options.addArguments("--disable-save-password-bubble");
    options.addArguments("--disable-features=PasswordLeakDetection");// отключает менеджер паролей
    options.addArguments("--incognito");
    driver = new ChromeDriver(options);
    driver.get("https://www.saucedemo.com/");
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
  @Test
  void testAddItems() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    inventoryPage.addToCart();
    Thread.sleep(2000);
    assertTrue(driver.getCurrentUrl().contains("cart"));
    assertEquals(2, cartPage.getCountItems());
  }

  @Test
  void testRemoveItems() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    inventoryPage.addToCart();
    //Thread.sleep(2000);
    cartPage.removeItems();
    //Thread.sleep(5000);
    assertEquals(0, cartPage.getCountItems());
  }

  @Test
  void testBuyItems()  {
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.login("standard_user", "secret_sauce");
    inventoryPage.addToCart();
    cartPage.goToCheckout();
    checkoutPage.inputInformation("test","test","18909123");
    checkoutPage.clickFinish();
    String finish_text = checkoutPage.getThankYouText();
    assertEquals("Thank you for your order!",finish_text);
    checkoutPage.clickBackHome();
    assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("inventory"));
  }
}
