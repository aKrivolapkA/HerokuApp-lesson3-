package tests;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ContextMenuPage.popUpText;

/*
Правый клик по элементу
Валидация текста на алерте
Закрытие алерта
 */
public class ContextMenuTest extends BaseTest {
    @Test
    public void test1() {
        contextMenuPage
                .openPage()
                .clickElement();
        Assert.assertEquals(contextMenuPage.getText(), popUpText);
        contextMenuPage
                .acceptAlert()
                .isElementDisplayed();
    }
}