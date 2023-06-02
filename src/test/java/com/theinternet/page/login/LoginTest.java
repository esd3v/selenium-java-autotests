package com.theinternet.page.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.common.BaseTest;
import com.theinternet.component.alert.AlertComponent;
import com.theinternet.page.secure.SecurePage;

import io.qase.api.annotation.QaseId;

public class LoginTest extends BaseTest {

  @ParameterizedTest
  @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
  @QaseId(15)
  public void testLoginPageOpen(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.load();

    assertEquals(loginPage.getExpectedHeaderText(), loginPage.getHeaderText());
    assertEquals(loginPage.getExpectedSubheaderText(), loginPage.getSubheaderText());

    assertTrue(loginPage.isUsernameLabelDisplayed());
    assertEquals(loginPage.getExpectedUsernameLabelText(), loginPage.getUsernameLabelText());

    assertTrue(loginPage.isUsernameInputDisplayed());

    assertTrue(loginPage.isPasswordLabelDisplayed());
    assertEquals(loginPage.getExpectedPasswordLabelText(), loginPage.getPasswordLabelText());

    assertTrue(loginPage.isPasswordInputDisplayed());

    assertTrue(loginPage.isLoginButtonDisplayed());
    assertEquals(loginPage.getExpectedLoginButtonText(), loginPage.getLoginButtonText());
    assertTrue(loginPage.isLoginButtonIconDisplayed());
  }

  @ParameterizedTest
  @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
  @QaseId(16)
  public void testSubmitEmptyForm(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    LoginPage loginPage = new LoginPage(driver);
    AlertComponent alertComponent = new AlertComponent(driver);

    loginPage.load();
    loginPage.submit();
    // Check if page redirected back to /login
    loginPage.isLoaded();

    WebElement loginPageErrorAlert = alertComponent.getAlertByText(loginPage.getExpectedInvalidUsernameAlertText());

    assertTrue(loginPageErrorAlert.isDisplayed());
    assertTrue(alertComponent.isError(loginPageErrorAlert));
    assertTrue(alertComponent.clickAlertCloseAndWaitToDetach(loginPageErrorAlert));

  }

  @ParameterizedTest
  @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
  @QaseId(13)
  public void testSubmitValidForm(Class<? extends WebDriver> webDriverClass) throws InterruptedException {
    WebDriver driver = createDriver(webDriverClass);
    LoginPage loginPage = new LoginPage(driver);
    SecurePage securePage = new SecurePage(driver);
    AlertComponent alertComponent = new AlertComponent(driver);

    loginPage.load();
    loginPage.fillPasswordInput(loginPage.getExpectedPasswordValue());
    loginPage.fillUsernameInput(loginPage.getExpectedUsernameValue());
    loginPage.submit();

    securePage.isLoaded();

    WebElement securePageSuccessAlert = alertComponent.getAlertByText(securePage.getExpectedSuccessAlertText());

    assertTrue(securePageSuccessAlert.isDisplayed());
    assertTrue(alertComponent.isSuccess(securePageSuccessAlert));
    assertTrue(alertComponent.clickAlertCloseAndWaitToDetach(securePageSuccessAlert));

    assertEquals(securePage.getExpectedHeaderText(), securePage.getHeaderText());
    assertEquals(securePage.getExpectedSubheaderText(), securePage.getSubheaderText());

    assertTrue(securePage.isLogoutButtonDisplayed());
    assertEquals(securePage.getExpectedLogoutButtonText(), securePage.getLogoutButtonText());

  }

}