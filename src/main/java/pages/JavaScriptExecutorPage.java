package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptExecutorPage extends BasePage {
    public static String url = "http://the-internet.herokuapp.com/";
    public double pixelsToScroll = 0.050;

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

    public JavaScriptExecutorPage scrollByPixels(double pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
        return this;
    }

    public JavaScriptExecutorPage scrollToMultiplyWindows() {
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