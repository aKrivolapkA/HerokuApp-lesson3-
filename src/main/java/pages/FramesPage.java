package pages;

import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public static String url = "https://demoqa.com/frames";
    public static String correctText = "This is a sample page";
    public static String iFrame = "frame1";
    public static String idFrame = "sampleHeading";

    public void openPage(String url) {
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