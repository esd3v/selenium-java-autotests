package com.common;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.theinternet.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends BasePage<T>> extends LoadableComponent<T> {
  public static Logger log = LogManager.getLogger(BasePage.class.getName());

  protected String baseURL;
  protected final WebDriver driver;

  public BasePage(WebDriver driver, String path) {
    this.driver = driver;
    this.baseURL = Constants.BASE_URL + "/" + path;
  }

  @Override
  public void load() {
    driver.get(baseURL);
  }

  @Override
  public void isLoaded() throws Error {
    String url = driver.getCurrentUrl();
    assertTrue(url.contains(baseURL));
  }
}
