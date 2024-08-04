package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptExecutorPage extends BasePage{
    public static String url="http://the-internet.herokuapp.com/";

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    WebElement multipleWindows;

    public WebElement getMultipleWindows() {
        return multipleWindows;
    }

    public JavaScriptExecutorPage(WebDriver driver) {
        super(driver);
    }
    public JavaScriptExecutorPage openPage() {
        driver.get(url);
        return this;
    }
    public JavaScriptExecutorPage scrollByPixels(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,050)");
        return this;
    }
    public JavaScriptExecutorPage scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", multipleWindows);
        return this;
    }
    public JavaScriptExecutorPage scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }
    public JavaScriptExecutorPage scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        return this;
    }
}