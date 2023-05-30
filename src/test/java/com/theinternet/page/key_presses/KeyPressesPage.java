package com.theinternet.page.key_presses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class KeyPressesPage extends BasePage<KeyPressesPage> {
  private By input = By.tagName("input");
  private By result = By.cssSelector("#result");

  public KeyPressesPage(WebDriver driver) {
    super(driver, "key_presses");
  }

  public WebElement getInputElement() {
    return this.driver.findElement(input);
  }

  public WebElement getResultElement() {
    return this.driver.findElement(result);
  }

  public String getResultText() {
    return this.getResultElement().getText();
  }

  public String getResultValue() {
    return this.getResultText().split(":")[1].trim();
  }

}