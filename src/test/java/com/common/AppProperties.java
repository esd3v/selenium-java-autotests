package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
  private static final String path = "src/main/resources/app.properties";
  private Properties properties;

  public AppProperties() {
    properties = new Properties();
    loadProperties();
  }

  private void loadProperties() {
    try (FileInputStream fileInputStream = new FileInputStream(path)) {
      properties.load(fileInputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
