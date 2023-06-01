package com.common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    protected Logger log = LogManager.getLogger(BaseTest.class.getName());
    protected WebDriver driver;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    public WebDriver createDriver(Class<? extends WebDriver> webDriverClass, Integer... dimensions) {
        int width = (dimensions.length > 0) ? dimensions[0] : 1024;
        int height = (dimensions.length > 1) ? dimensions[1] : 768;
        int timeout = (dimensions.length > 2) ? dimensions[2] : 10;

        driver = WebDriverManager.getInstance(webDriverClass).create();

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
