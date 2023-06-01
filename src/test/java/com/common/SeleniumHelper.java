package com.common;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
    public static Logger log = LogManager.getLogger(SeleniumHelper.class.getName());

    static public boolean elementExists(WebDriver driver, By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public static void waitForElementToDetach(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

}
