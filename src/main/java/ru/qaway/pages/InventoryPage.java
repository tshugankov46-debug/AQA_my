package ru.qaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class InventoryPage {

  WebDriver driver;

  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }


  public String getTitle(){
    return  driver.findElement(titlePage).getText();
  }

  public int getProductCount(){
    return driver.findElements(inventoryItem).size();
  }

  By titlePage = By.cssSelector(".title");
  By inventoryItem = By.cssSelector(".inventory_item");

}