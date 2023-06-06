package com.common;

import javax.annotation.Nullable;

public class AppConfig {
  private AppProperties appProperties;

  public AppConfig() {
    appProperties = new AppProperties();
  }

  @Nullable
  public Boolean isHeadless() {
    return Boolean.parseBoolean(appProperties.getProperty("BROWSER_HEADLESS"));
  }

  @Nullable
  public String firefoxBinaryPath() {
    return appProperties.getProperty("BROWSER_FIREFOX_BINARY_PATH");
  }

  @Nullable
  public String chromeBinaryPath() {
    return appProperties.getProperty("BROWSER_CHROME_BINARY_PATH");
  }
}
