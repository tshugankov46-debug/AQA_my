package ru.qaway.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CheckoutPage {
  WebDriver driver;
  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
  }
  By firstName = By.id("first-name");
  By lastName = By.id("last-name");
  By postCode = By.id("postal-code");
  By continuePage = By.id("continue");
  By finishButton = By.id("finish");
  By thankYouText = By.cssSelector(".complete-header");
  By backHomeButton = By.id("back-to-products");


  public void inputInformation(String firstname,String lastname, String postcode){
    driver.findElement(firstName).sendKeys(firstname);
    driver.findElement(lastName).sendKeys(lastname);
    driver.findElement(postCode).sendKeys(postcode);
    driver.findElement(continuePage).click();
  }

  public void clickFinish() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(finishButton));
    driver.findElement(finishButton).click();
  }

  public String getThankYouText() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouText));
    return driver.findElement(thankYouText).getText();
  }

  public void clickBackHome() {
    driver.findElement(backHomeButton).click();
  }

}

