package com.theinternet.page.key_presses;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.theinternet.Constants;

public class KeyPressesPage extends LoadableComponent<KeyPressesPage> {
  public static Logger log = LogManager.getLogger(KeyPressesPage.class.getName());

  private String baseURL = Constants.BASE_URL + "/key_presses";

  private final WebDriver driver;

  public KeyPressesPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getInputElement() {
    return this.driver.findElement(By.tagName("input"));
  }

  public WebElement getResultElement() {
    return this.driver.findElement(By.cssSelector("#result"));
  }

  public String getResultText() {
    return this.getResultElement().getText();
  }

  public String getResultValue() {
    return this.getResultText().split(":")[1].trim();
  }

  @Override
  protected void load() {
    driver.get(baseURL);
  }

  @Override
  protected void isLoaded() throws Error {
    String url = driver.getCurrentUrl();

    assertTrue(url.contains(baseURL));
  }

}