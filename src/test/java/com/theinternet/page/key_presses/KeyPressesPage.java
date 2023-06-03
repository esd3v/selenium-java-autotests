package com.theinternet.page.key_presses;

import com.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage extends BasePage<KeyPressesPage> {
  private String inputTag = "input";
  private String resultId = "result";

  public KeyPressesPage(WebDriver driver) {
    super(driver, "key_presses");
  }

  public WebElement getInputElement() {
    return this.driver.findElement(By.tagName(inputTag));
  }

  public WebElement getResultElement() {
    return this.driver.findElement(By.id(resultId));
  }

  public String getResultText() {
    return this.getResultElement().getText();
  }

  public String getResultValue() {
    return this.getResultText().split(":")[1].trim();
  }
}
