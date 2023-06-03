package com.theinternet.page.secure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.common.BaseTest;
import com.theinternet.component.alert.AlertComponent;
import com.theinternet.page.login.LoginPage;
import io.qase.api.annotation.QaseId;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SecureTest extends BaseTest {

  @ParameterizedTest
  @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
  @QaseId(19)
  public void testUnauthenticatedSecurePageOpen(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    LoginPage loginPage = new LoginPage(driver);
    SecurePage securePage = new SecurePage(driver);
    AlertComponent alertComponent = new AlertComponent(driver);

    securePage.load();

    loginPage.isLoaded();

    WebElement securePageErrorAlert =
        alertComponent.getAlertByText(loginPage.getExpectedUnauthenticatedSecurePageAlertText());

    assertTrue(securePageErrorAlert.isDisplayed());
    assertTrue(alertComponent.isError(securePageErrorAlert));
    assertTrue(alertComponent.clickAlertCloseAndWaitToDetach(securePageErrorAlert));
  }
}
