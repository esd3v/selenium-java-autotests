package com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public abstract class BaseTest {
  protected Logger log = LogManager.getLogger(BaseTest.class.getName());
  protected WebDriver driver;

  @BeforeAll
  static void setUpDriver() {
    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();
  }

  public WebDriver createDriver(Class<? extends WebDriver> webDriverClass, Integer... dimensions) {
    AppConfig appConfig = new AppConfig();
    Capabilities options = null;

    int width = (dimensions.length > 0) ? dimensions[0] : 1920;
    int height = (dimensions.length > 1) ? dimensions[1] : 1080;
    int timeout = (dimensions.length > 2) ? dimensions[2] : 10;

    if (webDriverClass == ChromeDriver.class) {
      ChromeOptions chromeOptions = new ChromeOptions();

      if (appConfig.isHeadless()) {
        chromeOptions.addArguments("--headless");
      }

      options = chromeOptions;
    } else if (webDriverClass == FirefoxDriver.class) {
      FirefoxOptions firefoxOptions = new FirefoxOptions();

      if (appConfig.isHeadless()) {
        firefoxOptions.addArguments("-headless");
      }

      options = firefoxOptions;
    }

    driver = WebDriverManager.getInstance(webDriverClass).capabilities(options).create();

    Dimension dm = new Dimension(width, height);
    driver.manage().window().setSize(dm);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

    return driver;
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
