package com.theinternet.page.key_presses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.common.BaseTest;
import io.qase.api.annotation.QaseId;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressesTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
  @QaseId(11)
  public void testKeyValueDisplay(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    KeyPressesPage keyPressesPage = new KeyPressesPage(driver);

    keyPressesPage.load();

    WebElement input = keyPressesPage.getInputElement();

    Object[] keys = {
      Keys.ESCAPE,
      Keys.F1,
      Keys.F2,
      Keys.F3,
      "`",
      "q",
      "w",
      "e",
      "r",
      "t",
      "y",
      "u",
      "i",
      "o",
      "p",
      "[",
      "]"
    };

    for (Object item : keys) {
      String expected;

      if (item == Keys.ESCAPE) {
        expected = "escape";
      } else if (item == Keys.F1) {
        expected = "f1";
      } else if (item == Keys.F2) {
        expected = "f2";
      } else if (item == Keys.F3) {
        expected = "f3";
      } else if (item == "`") {
        expected = "BACK_QUOTE";
      } else if (item == "[") {
        expected = "OPEN_BRACKET";
      } else if (item == "]") {
        expected = "CLOSE_BRACKET";
      } else {
        expected = item.toString();
      }

      if (item instanceof Keys) {
        Keys key = (Keys) item;
        input.sendKeys(key);
      } else if (item instanceof String) {
        String str = (String) item;
        input.sendKeys(str);
      }

      String resultValue = keyPressesPage.getResultValue();

      assertEquals(expected.toUpperCase(), resultValue);
    }
  }
}
