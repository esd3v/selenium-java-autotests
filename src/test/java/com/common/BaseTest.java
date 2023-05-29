package com.common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected Logger log = LogManager.getLogger(BaseTest.class.getName());
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
        Dimension dm = new Dimension(1024, 768);
        driver.manage().window().setSize(dm);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
