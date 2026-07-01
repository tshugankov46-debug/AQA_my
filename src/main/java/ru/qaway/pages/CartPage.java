package ru.qaway.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
  WebDriver driver;

  By cartItems = By.cssSelector(".cart_item");
  By removeBikeLight = By.id("remove-sauce-labs-bike-light");
  By removeBackpack = By.id("remove-sauce-labs-backpack");
  By checkout = By.id("checkout");


  public CartPage(WebDriver driver) {
    this.driver = driver;
  }
  public int getCountItems() {
    return driver.findElements(cartItems).size();
  }
  public void removeItems(){
    driver.findElement(removeBackpack).click();
    driver.findElement(removeBikeLight).click();
  }
  public void goToCheckout(){
    driver.findElement(checkout).click();
  }

}
