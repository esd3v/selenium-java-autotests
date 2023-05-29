package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.qase.api.annotation.QaseId;

public class DisappearingElementsTest {
  public static Logger log = LogManager.getLogger(DisappearingElementsTest.class.getName());
  private DisappearingElementsPage disappearingElementsPage;
  private WebDriver driver;

  @BeforeEach
  public void setup() {
    driver = new FirefoxDriver();
    Dimension dm = new Dimension(1024, 768);

    driver.manage().window().setSize(dm);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    disappearingElementsPage = new DisappearingElementsPage(driver);
  }

  @Test
  @QaseId(10)
  public void testElementAppearance() {
    this.disappearingElementsPage.load();
    WebElement list = this.disappearingElementsPage.getList();

    List<WebElement> items = list.findElements(By.tagName("li"));
    assertEquals(disappearingElementsPage.totalItems, items.size());

  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
