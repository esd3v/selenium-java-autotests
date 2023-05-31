package com.theinternet.page.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.common.BaseTest;

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
  @QaseId(13)
  public void testSendEmptyForm(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    LoginPage loginPage = new LoginPage(driver);

    loginPage.load();

    loginPage.submit();

    // Check if page redirected back to /login
    loginPage.isLoaded();

    assertTrue(loginPage.isAlertVisible());
    assertTrue(loginPage.isAlertError());
  }
}
