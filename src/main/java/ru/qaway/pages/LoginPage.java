package ru.qaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

  WebDriver driver;

  By usernameField = By.id("user-name");
  By passwordField = By.id("password");
  By loginButton = By.id("login-button");
  By errorMessage = By.cssSelector(".error-message-container");
  By logoPage = By.cssSelector(".login_logo");


  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }
  public String getErrorMessage() {
    return driver.findElement(errorMessage).getText();
  }
  public String getTitle(){
    return  driver.findElement(logoPage).getText();
  }
  public void login(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
  }
}