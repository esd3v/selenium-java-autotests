package com.common;

public class AppConfig {
    private AppProperties appProperties;

    public AppConfig() {
        appProperties = new AppProperties();
    }

    public Boolean isHeadless() {
        return Boolean.parseBoolean(appProperties.getProperty("BROWSER_HEADLESS"));
    }

}
