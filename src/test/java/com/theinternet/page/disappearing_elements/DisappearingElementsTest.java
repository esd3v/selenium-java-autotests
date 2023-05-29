package com.theinternet.page.disappearing_elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
  @QaseId(10)
  public void testElementAppearance() {
    this.disappearingElementsPage.load();

    WebElement list = this.disappearingElementsPage.getList();

    List<WebElement> items = list.findElements(By.tagName("li"));
    assertEquals(disappearingElementsPage.totalItems, items.size());

  }

}
