package tests;

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
    public void testAcceptAlert() {
        contextMenuPage
                .openPage()
                .rightClickOnElement();
        Assert.assertEquals(contextMenuPage.getText(), popUpText);
        contextMenuPage
                .acceptAlert();
        Assert.assertTrue(contextMenuPage.getSomeRandomeElement().isDisplayed());

    }
}