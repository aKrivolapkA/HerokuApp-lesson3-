package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.FramesPage.*;


/*
Открыть iFrame
Проверить, что текст внутри параграфа равен “This is a sample page”

 */
public class FramesTest extends BaseTest{
    @Test
    public void test4(){
        framesPage.openPage();
        Assert.assertEquals(driver.switchTo().frame(iFrame).findElement(By.id("sampleHeading")).getText(),correctText);
    }
}