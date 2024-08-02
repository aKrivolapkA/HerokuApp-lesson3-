package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NotificationMessages {
    private WebDriver driver;
    private String NotificationMessages = "Action successful";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(invocationCount = 5)
    public void hoversUserOneTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.partialLinkText("here")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        if (message != NotificationMessages) {
            driver.findElement(By.partialLinkText("here")).click();
        } else {
            Assert.assertEquals(message, NotificationMessages);
        }
        driver.quit();
    }
}