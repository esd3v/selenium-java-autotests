package com.theinternet.component.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BaseComponent;

public class AlertComponent extends BaseComponent {
    private String containerClass = "flash";
    private String closeClass = "close";
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

    public void clickClose(WebElement alert) {
        getCloseButton(alert).click();
    }
}
