package com.theinternet.page.key_presses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.common.BaseTest;

import io.qase.api.annotation.QaseId;

public class KeyPressesTest extends BaseTest {
  private KeyPressesPage keyPressesPage;

  @BeforeEach
  public void setupKeyPressesPage() {
    keyPressesPage = new KeyPressesPage(driver);
  }

  @Test
  @QaseId(11)
  public void testKeyValueDisplay() {
    this.keyPressesPage.load();

    WebElement input = this.keyPressesPage.getInputElement();

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
