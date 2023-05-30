package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.common.BaseTest;

import io.qase.api.annotation.QaseId;

public class DisappearingElementsTest extends BaseTest {
  private DisappearingElementsPage disappearingElementsPage;

  @BeforeEach
  public void setupDisappearingElementsPage() {
    disappearingElementsPage = new DisappearingElementsPage(driver);
  }

  @Test
  @RepeatedTest(10)
  @QaseId(10)
  public void testElementAppearance() {
    this.disappearingElementsPage.load();

    List<WebElement> items = disappearingElementsPage.getItems();
    assertEquals(disappearingElementsPage.expectedItems, items.size());

  }

}
