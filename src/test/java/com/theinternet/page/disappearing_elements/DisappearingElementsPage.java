package com.theinternet.page.disappearing_elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class DisappearingElementsPage extends BasePage<DisappearingElementsPage> {
  public Number expectedItemCount = 5;
  private String listTag = "ul";
  private String itemsTag = "li";
  private String[] expectedItemText = { "Home", "About", "Contact Us", "Portfolio", "Gallery" };

  public String[] getExpectedItemText() {
    return expectedItemText;
  }

  public DisappearingElementsPage(WebDriver driver) {
    super(driver, "disappearing_elements");
  }

  public WebElement getList() {
    return driver.findElement(By.tagName(listTag));
  }

  public Number getExpectedItemCount() {
    return expectedItemCount;
  }

  public List<WebElement> getItems() {
    return getList().findElements(By.tagName(itemsTag));
  }

  public Number getItemCount() {
    return getItems().size();
  }
}