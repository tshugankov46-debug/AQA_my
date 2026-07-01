package ru.qaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

  WebDriver driver;
  By titlePage = By.cssSelector(".title");
  By inventoryItem = By.cssSelector(".inventory_item");
  By buttonAddBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
  By buttonAddBackPack = By.id("add-to-cart-sauce-labs-backpack");
  By shoppingCartContainer = By.id ("shopping_cart_container");
  public InventoryPage(WebDriver driver) {
    this.driver = driver;
  }
  public String getTitle(){
    return  driver.findElement(titlePage).getText();
  }
  public int getProductCount(){
    return driver.findElements(inventoryItem).size();
  }

  public void addToCart (){
    driver.findElement(buttonAddBackPack).click();
    driver.findElement(buttonAddBikeLight).click();
    driver.findElement(shoppingCartContainer).click();
  }
}