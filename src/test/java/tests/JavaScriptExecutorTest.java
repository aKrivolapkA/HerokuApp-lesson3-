package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {
    @Test
    public void test7(){
        javaScriptExecutorPage
                .openPage()
                .scrollByPixels()
                .scrollToElement();
        Assert.assertTrue(javaScriptExecutorPage.getMultipleWindows().isDisplayed());
        javaScriptExecutorPage
                .scrollToBottom()
                .scrollToTop();
    }
}
