package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{

    public static String url="https://demoqa.com/frames";
    public static String correctText="This is a sample page";
    public static String iFrame="frame1";

    public static String getCorrectText() {
        return correctText;
    }

    public void openPage(String url){
        driver.get(url);
    }
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    public FramesPage openPage() {
        driver.get(url);
        return this;
    }

}