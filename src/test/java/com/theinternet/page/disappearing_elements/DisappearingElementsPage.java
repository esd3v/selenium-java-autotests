package com.theinternet.page.disappearing_elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class DisappearingElementsPage extends BasePage<DisappearingElementsPage> {
  public Number expectedItems = 5;

  private By list = By.tagName("ul");
  private By items = By.tagName("li");

  public DisappearingElementsPage(WebDriver driver) {
    super(driver, "disappearing_elements");
  }

  public WebElement getList() {
    return driver.findElement(list);
  }

  public List<WebElement> getItems() {
    return getList().findElements(items);
  }

}