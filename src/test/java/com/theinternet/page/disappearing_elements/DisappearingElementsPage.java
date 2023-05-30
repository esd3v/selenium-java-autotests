package com.theinternet.page.disappearing_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class DisappearingElementsPage extends BasePage<DisappearingElementsPage> {
  public Number totalItems = 5;

  public DisappearingElementsPage(WebDriver driver) {
    super(driver, "disappearing_elements");
  }

  public WebElement getList() {
    return driver.findElement(By.tagName("ul"));
  }

}