package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.theinternet.Constants;

public class DisappearingElementsPage extends LoadableComponent<DisappearingElementsPage> {
  public static Logger log = LogManager.getLogger(DisappearingElementsPage.class.getName());

  private String baseURL = Constants.BASE_URL + "/disappearing_elements";
  public Number totalItems = 5;

  private final WebDriver driver;

  public DisappearingElementsPage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getList() {
    return driver.findElement(By.tagName("ul"));
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