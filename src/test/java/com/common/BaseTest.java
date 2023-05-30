package com.common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    public WebDriver createDriver(Class<? extends WebDriver> webDriverClass) {
        driver = WebDriverManager.getInstance(webDriverClass).create();
        setUpDriverConfig(driver);
        return driver;
    }

    public void setUpDriverConfig(WebDriver driver) {
        Dimension dm = new Dimension(1024, 768);
        driver.manage().window().setSize(dm);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
