package com.theinternet.page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class LoginPage extends BasePage<LoginPage> {
  public LoginPage(WebDriver driver) {
    super(driver, "login");
  }

  // Alert
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String expectedInvalidUsernameAlertText = "Your username is invalid!";
  private String expectedUnauthenticatedSecurePageAlertText = "You must login to view the secure area!";

  public String getExpectedUnauthenticatedSecurePageAlertText() {
    return expectedUnauthenticatedSecurePageAlertText;
  }

  public String getExpectedInvalidUsernameAlertText() {
    return expectedInvalidUsernameAlertText;
  }

  // Header
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String headerTag = "h2";
  private String subheaderTag = "h4";
  private String expectedHeaderText = "Login Page";
  private String expectedSubheaderText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

  public String getExpectedHeaderText() {
    return expectedHeaderText;
  }

  public String getExpectedSubheaderText() {
    return expectedSubheaderText;
  }

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
  private String expectedUsernameLabelText = "Username";
  private String expectedPasswordLabelText = "Password";

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
  private String expectedUsernameValue = "tomsmith";
  private String expectedPasswordValue = "SuperSecretPassword!";

  public String getExpectedUsernameLabelText() {
    return expectedUsernameLabelText;
  }

  public String getExpectedPasswordLabelText() {
    return expectedPasswordLabelText;
  }

  public String getExpectedUsernameValue() {
    return expectedUsernameValue;
  }

  public String getExpectedPasswordValue() {
    return expectedPasswordValue;
  }

  public WebElement getUsernameInput() {
    return driver.findElement(By.id(usernameInputId));
  }

  public WebElement getPasswordInput() {
    return driver.findElement(By.id(passwordInputId));
  }

  public boolean isUsernameInputDisplayed() {
    return getUsernameInput().isDisplayed();
  }

  public boolean isPasswordInputDisplayed() {
    return getPasswordInput().isDisplayed();
  }

  public void fillUsernameInput(String username) {
    WebElement usernameInput = getUsernameInput();
    usernameInput.clear();
    usernameInput.sendKeys(username);
  }

  public void fillPasswordInput(String password) {
    WebElement passwordInput = getPasswordInput();
    passwordInput.clear();
    passwordInput.sendKeys(password);
  }

  // Login button
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String loginButtonSelector = "button[type='submit']";
  private String expectedLoginButtonText = "Login";

  public String getExpectedLoginButtonText() {
    return expectedLoginButtonText;
  }

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

}
