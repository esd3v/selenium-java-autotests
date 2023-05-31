package com.theinternet.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;
import com.theinternet.component.alert.AlertComponent;

public class LoginPage extends BasePage<LoginPage> {
  private String expectedHeaderText = "Login Page";
  private String expectedSubheaderText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
  private String expectedUsernameLabelText = "Username";
  private String expectedPasswordLabelText = "Password";
  private String expectedLoginButtonText = "Login";
  private String expectedErrorAlertText = "Your username is invalid!";

  public LoginPage(WebDriver driver) {
    super(driver, "login");
    alertComponent = new AlertComponent(driver);
  }

  // Alert
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  public AlertComponent alertComponent;

  private WebElement getAlert() {
    return alertComponent.getAlertsByText(expectedErrorAlertText).get(0);
  }

  public boolean isAlertError() {
    return alertComponent.isError(getAlert());
  }

  public boolean isAlertVisible() {
    return alertComponent.isError(getAlert());
  }

  // Header
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String headerTag = "h2";
  private String subheaderTag = "h4";

  public String getHeaderText() {
    return driver.findElement(By.tagName(headerTag)).getText();
  }

  public String getSubheaderText() {
    return driver.findElement(By.tagName(subheaderTag)).getText();
  }

  // Labels
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String usernameLabelSelector = "label[for='username']";
  private String passwordLabelSelector = "label[for='password']";

  public boolean isUsernameLabelDisplayed() {
    return driver.findElement(By.cssSelector(usernameLabelSelector)).isDisplayed();
  }

  public String getUsernameLabelText() {
    return driver.findElement(By.cssSelector(usernameLabelSelector)).getText();
  }

  public boolean isPasswordLabelDisplayed() {
    return driver.findElement(By.cssSelector(passwordLabelSelector)).isDisplayed();
  }

  public String getPasswordLabelText() {
    return driver.findElement(By.cssSelector(passwordLabelSelector)).getText();
  }

  // Inputs
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String usernameInputId = "username";
  private String passwordInputId = "password";

  public boolean isUsernameInputDisplayed() {
    return driver.findElement(By.id(usernameInputId)).isDisplayed();
  }

  public boolean isPasswordInputDisplayed() {
    return driver.findElement(By.id(passwordInputId)).isDisplayed();
  }

  // Login button
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String loginButtonSelector = "button[type='submit']";

  public WebElement getLoginButtonElement() {
    return driver.findElement(By.cssSelector(loginButtonSelector));
  }

  public void submit() {
    getLoginButtonElement().click();
  }

  public boolean isLoginButtonDisplayed() {
    return getLoginButtonElement().isDisplayed();
  }

  public String getLoginButtonText() {
    return getLoginButtonElement().getText();
  }

  public boolean isLoginButtonIconDisplayed() {
    WebElement iconElement = getLoginButtonElement().findElement(By.tagName("i"));
    return iconElement.isDisplayed();
  }

  // Getters
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  public String getExpectedHeaderText() {
    return expectedHeaderText;
  }

  public String getExpectedSubheaderText() {
    return expectedSubheaderText;
  }

  public String getExpectedUsernameLabelText() {
    return expectedUsernameLabelText;
  }

  public String getExpectedPasswordLabelText() {
    return expectedPasswordLabelText;
  }

  public String getExpectedLoginButtonText() {
    return expectedLoginButtonText;
  }

}
