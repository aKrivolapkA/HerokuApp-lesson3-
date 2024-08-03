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
public class DynamicControlsTest  extends  BaseTest{
    @Test
    public void test2() {
        dynamicControlsPage
                .openPage()
                .clickCheckbox()
                .clickRemoveButton()
                .waitUntilVisible();
        Assert.assertTrue(dynamicControlsPage.isElementInvisible());
        Assert.assertFalse(dynamicControlsPage.isInputDisable());
        dynamicControlsPage
                .clickOnEnableButton()
            .waitUntilVisible2();
        Assert.assertTrue(dynamicControlsPage.isInputDisable());
    }
}