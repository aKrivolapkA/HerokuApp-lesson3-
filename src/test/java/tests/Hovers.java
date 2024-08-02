package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Сделать цепочку из действий:
наведение на профиль,
проверка имени,
клик по ссылке,
 проверка что нет 404 ошибки.
 Повторить для каждого из профилей.
 Использовать класс Actions и https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java

 */

public class Hovers {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void hoversUserOneTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("(//*[@class='figure'])[1]"));
        action.moveToElement(we).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='name: user1']")).isDisplayed());
        driver.findElement(By.xpath("//a[@href='/users/1']")).click();
        Assert.assertNotEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")), 404);

        driver.quit();
    }
    @Test
    public void hoversUserTwoTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("(//*[@class='figure'])[2]"));
        action.moveToElement(we).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user2']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='name: user2']")).isDisplayed());
        driver.findElement(By.xpath("//a[@href='/users/2']")).click();
        Assert.assertNotEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")), 404);

        driver.quit();
    }
    @Test
    public void hoversUserThreeTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("(//*[@class='figure'])[3]"));
        action.moveToElement(we).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user3']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h5[text()='name: user3']")).isDisplayed());
        driver.findElement(By.xpath("//a[@href='/users/3']")).click();
        Assert.assertNotEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")), 404);

        driver.quit();
    }
}