package com.theinternet.page.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import com.theinternet.Constants;

public class LoginPage extends LoadableComponent<LoginPage> {
  public static Logger log = LogManager.getLogger(LoginPage.class.getName());

  private String baseURL = Constants.BASE_URL + "/login";

  private final WebDriver driver;

  private By usernameInput = By.id("username");
  private By passwordInput = By.id("password");
  private By loginButton = By.cssSelector("button[type='submit']");
  private By header = By.tagName("h2");
  private By subheader = By.tagName("h4");
  private By usernameLabel = By.cssSelector("label[for='username']");
  private By passwordLabel = By.cssSelector("label[for='password']");

  private String expectedHeaderText = "Login Page";
  private String expectedSubheaderText = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
  private String expectedUsernameLabelText = "Username";
  private String expectedPasswordLabelText = "Password";
  private String expectedLoginButtonText = "Login";

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getHeaderText() {
    return driver.findElement(header).getText();
  }

  public String getSubheaderText() {
    return driver.findElement(subheader).getText();
  }

  public boolean isUsernameLabelDisplayed() {
    return driver.findElement(usernameLabel).isDisplayed();
  }

  public String getUsernameLabelText() {
    return driver.findElement(usernameLabel).getText();
  }

  public boolean isUsernameInputDisplayed() {
    return driver.findElement(usernameInput).isDisplayed();
  }

  public boolean isPasswordLabelDisplayed() {
    return driver.findElement(passwordLabel).isDisplayed();
  }

  public String getPasswordLabelText() {
    return driver.findElement(passwordLabel).getText();
  }

  public boolean isPasswordInputDisplayed() {
    return driver.findElement(passwordInput).isDisplayed();
  }

  public boolean isLoginButtonDisplayed() {
    return driver.findElement(loginButton).isDisplayed();
  }

  public String getLoginButtonText() {
    return driver.findElement(loginButton).getText();
  }

  public boolean isLoginButtonIconDisplayed() {
    WebElement buttonElement = driver.findElement(loginButton);
    WebElement iconElement = buttonElement.findElement(By.tagName("i"));
    return iconElement.isDisplayed();
  }

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

  @Override
  protected void load() {
    driver.get(baseURL);
  }

  @Override
  protected void isLoaded() throws Error {
    String url = driver.getCurrentUrl();

    assertTrue(url.contains(baseURL));
  }

}