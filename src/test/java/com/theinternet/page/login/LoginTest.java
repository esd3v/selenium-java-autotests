package com.theinternet.page.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.common.BaseTest;

import io.qase.api.annotation.QaseId;

public class LoginTest extends BaseTest {
  public static Logger log = LogManager.getLogger(LoginPage.class.getName());
  private LoginPage loginPage;

  @BeforeEach
  public void setupLoginPage() {
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

}
