package com.theinternet.component.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BaseComponent;
import com.common.SeleniumHelper;

public class AlertComponent extends BaseComponent {
    private String containerClass = "flash";
    private String closeClass = "close";
    private String successClass = "success";
    private String errorClass = "error";

    public AlertComponent(WebDriver driver) {
        super(driver);
    }

    public By getAlertLocatorByText(String text) {
        return By.xpath("//*[contains(text(), '" + text + "') and contains(@class, '" + containerClass + "')]");
    }

    public WebElement getAlertByText(String text) {
        return driver.findElement(getAlertLocatorByText(text));
    }

    public WebElement getCloseButton(WebElement alert) {
        return alert.findElement(By.className(closeClass));
    }

    public boolean isError(WebElement alert) {
        return alert.getAttribute("class").contains(errorClass);
    }

    public boolean isSuccess(WebElement alert) {
        return alert.getAttribute("class").contains(successClass);
    }

    public void clickClose(WebElement alert) {
        getCloseButton(alert).click();
    }

    public boolean clickAlertCloseAndWaitToDetach(WebElement alert) {
        clickClose(alert);

        try {
            SeleniumHelper.waitForElementToDetach(driver, alert, 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
