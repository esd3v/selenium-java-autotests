package com.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {
  public static Logger log = LogManager.getLogger(BaseComponent.class.getName());

  protected final WebDriver driver;

  public BaseComponent(WebDriver driver) {
    this.driver = driver;
  }
}
