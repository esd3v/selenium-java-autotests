package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.common.BaseTest;
import io.qase.api.annotation.QaseId;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DisappearingElementsTest extends BaseTest {
  @ParameterizedTest
  @ValueSource(classes = {ChromeDriver.class, FirefoxDriver.class})
  // @RepeatedTest(10) Doesn't work with @ParameterizedTest
  @QaseId(10)
  public void testElementAppearance(Class<? extends WebDriver> webDriverClass) {
    WebDriver driver = createDriver(webDriverClass);
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage(driver);

    ArrayList<String> itemText = new ArrayList<>();

    disappearingElementsPage.load();

    for (WebElement item : disappearingElementsPage.getItems()) {
      String text = item.getText();
      itemText.add(text);
    }

    Boolean isEqual =
        Arrays.asList(disappearingElementsPage.getExpectedItemText()).equals(itemText);

    assertTrue(isEqual);
  }
}
