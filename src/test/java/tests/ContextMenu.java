package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Правый клик по элементу
Валидация текста на алерте
Закрытие алерта
 */
public class ContextMenu {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void hoversUserOneTest() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.cssSelector("#hot-spot"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "You selected a context menu");
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']")).isDisplayed());
        driver.close();
    }
}