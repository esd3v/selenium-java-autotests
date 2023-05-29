package com.theinternet.page.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.qase.api.annotation.QaseId;

public class LoginTest {
  public static Logger log = LogManager.getLogger(LoginTest.class.getName());
  private LoginPage loginPage;
  private WebDriver driver;

  @BeforeEach
  public void setup() {
    driver = new FirefoxDriver();

    Dimension dm = new Dimension(1024, 768);

    driver.manage().window().setSize(dm);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    loginPage = new LoginPage(driver);
  }

  @Test
  @QaseId(15)
  public void testLoginPageOpen() {
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

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
