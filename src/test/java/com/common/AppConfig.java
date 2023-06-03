package com.common;

public class AppConfig {
  private AppProperties appProperties;

  public AppConfig() {
    appProperties = new AppProperties();
  }

  public Boolean isHeadless() {
    return Boolean.parseBoolean(appProperties.getProperty("BROWSER_HEADLESS"));
  }

  public String firefoxBinaryPath() {
    return appProperties.getProperty("BROWSER_FIREFOX_BINARY_PATH");
  }

  public String chromeBinaryPath() {
    return appProperties.getProperty("BROWSER_CHROME_BINARY_PATH");
  }
}
