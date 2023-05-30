package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.common.BaseTest;

import io.qase.api.annotation.QaseId;

public class DisappearingElementsTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(classes = { ChromeDriver.class, FirefoxDriver.class })
  // @RepeatedTest(10) Doesn't work with @ParameterizedTest
  @QaseId(10)
  public void testElementAppearance(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage(driver);

    disappearingElementsPage.load();

    List<WebElement> items = disappearingElementsPage.getItems();
    assertEquals(disappearingElementsPage.expectedItems, items.size());

  }

}
