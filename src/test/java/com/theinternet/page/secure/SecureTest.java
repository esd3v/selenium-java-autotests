package com.theinternet.page.secure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.common.BaseTest;
import com.theinternet.component.alert.AlertComponent;
import com.theinternet.page.login.LoginPage;

import io.qase.api.annotation.QaseId;

public class SecureTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
    @QaseId(19)
    public void testUnauthenticatedSecurePageOpen(Class<? extends WebDriver> webDriverClass) {
        WebDriver driver = createDriver(webDriverClass, 1920, 1080);
        LoginPage loginPage = new LoginPage(driver);
        SecurePage securePage = new SecurePage(driver);
        AlertComponent alertComponent = new AlertComponent(driver);

        securePage.load();

        loginPage.isLoaded();

        WebElement securePageErrorAlert = alertComponent
                .getAlertByText(loginPage.getExpectedUnauthenticatedSecurePageAlertText());

        assertTrue(securePageErrorAlert.isDisplayed());
        assertTrue(alertComponent.isError(securePageErrorAlert));
        assertTrue(alertComponent.clickAlertCloseAndWaitToDetach(securePageErrorAlert));
    }
}