package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ContextMenuPage;
import pages.DynamicControlsPage;
import pages.FileUploadPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    DynamicControlsPage dynamicControlsPage;
    ContextMenuPage contextMenuPage;
    FileUploadPage fileUploadPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);//инициализируем обьект веб драйвера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver, this);
    }

    public void initPages() {
        dynamicControlsPage = new DynamicControlsPage(driver);
        contextMenuPage = new ContextMenuPage(driver);
        fileUploadPage = new FileUploadPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
