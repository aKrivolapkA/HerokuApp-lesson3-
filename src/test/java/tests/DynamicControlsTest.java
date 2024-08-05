package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Найти чекбокс
Нажать на кнопку
Дождаться надписи “It’s gone”
Проверить, что чекбокса нет
Найти инпут
Проверить, что он disabled
Нажать на кнопку
Дождаться надписи “It's enabled!”
Проверить, что инпут enabled
 */
public class DynamicControlsTest extends BaseTest {
    @Test
    public void dynamicControlsTest() {
        dynamicControlsPage
                .openPage()
                .clickCheckbox()
                .clickRemoveButton()
                .waitUntilVisible("It's gone!");
        Assert.assertTrue(dynamicControlsPage.isElementInvisible());
        Assert.assertFalse(dynamicControlsPage.isInputFieldDisable());
        dynamicControlsPage
                .clickOnEnableButton()
                .waitUntilVisible("It's enabled!");
        Assert.assertTrue(dynamicControlsPage.isInputFieldDisable());
    }
}