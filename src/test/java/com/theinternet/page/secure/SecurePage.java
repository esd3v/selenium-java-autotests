package com.theinternet.page.secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.BasePage;

public class SecurePage extends BasePage<SecurePage> {
  public SecurePage(WebDriver driver) {
    super(driver, "secure");
  }

  // Alert
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String expectedSuccessAlertText = "You logged into a secure area!";

  public String getExpectedSuccessAlertText() {
    return expectedSuccessAlertText;
  }

  // Header
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String headerTag = "h2";
  private String subheaderTag = "h4";
  private String expectedHeaderText = "Secure Area";
  private String expectedSubheaderText = "Welcome to the Secure Area. When you are done click logout below.";

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

  // Logout button
  ///////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////
  private String logoutButtonClass = "button";
  private String expectedLogoutButtonText = "Logout";

  public String getExpectedLogoutButtonText() {
    return expectedLogoutButtonText;
  }

  public WebElement getLogoutButtonElement() {
    return driver.findElement(By.className(logoutButtonClass));
  }

  public void submit() {
    getLogoutButtonElement().click();
  }

  public boolean isLogoutButtonDisplayed() {
    return getLogoutButtonElement().isDisplayed();
  }

  public String getLogoutButtonText() {
    return getLogoutButtonElement().getText();
  }

}
