package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class FileDownloadPage{
    WebDriver driver;
    public static String url = "http://the-internet.herokuapp.com/download";
    public void download() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", chromePrefs);
        driver.get("http://the-internet.herokuapp.com/download");
        By downloadLinkLocator = By.xpath("//a[@href='download/Love.JPG']");
        WebElement downloadLink = driver.findElement(downloadLinkLocator);
        downloadLink.click();
        Thread.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }
     public  boolean found = false;
    public File f = null;
    public void check(){
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("5MB.zip")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
    }
}