package com.theinternet.component.alert;

import java.util.ArrayList;
import java.util.List;

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

    public List<WebElement> getAlerts() {
        return driver.findElements(By.className(containerClass));

    }

    public List<WebElement> getAlertsByText(String text) {
        List<WebElement> allAlerts = getAlerts();
        List<WebElement> alerts = new ArrayList<>();

        for (WebElement element : allAlerts) {
            String elementText = element.getText().split("\n")[0].trim();

            if (elementText.equals(text)) {
                alerts.add(element);
            }
        }

        return alerts;
    }

    public WebElement getCloseButton(WebElement alert) {
        return alert.findElement(By.className(closeClass));
    }

    public boolean isDisplayed(WebElement alert) {
        return alert.isDisplayed();
    }

    public boolean isError(WebElement alert) {
        return alert.getAttribute("class").contains(errorClass);
    }

    public void clickClose(WebElement alert) {
        getCloseButton(alert).click();
    }
}
