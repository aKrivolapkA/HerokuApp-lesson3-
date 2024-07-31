package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/*
 Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
 */
public class Inputs {
    public static final String RESULT = "//input";

    @Test
    public void inputsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");

        driver.findElement(By.tagName("input")).sendKeys("123");
        assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "123");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "124");

        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "123");
        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.tagName("input")).sendKeys("piszututslowa");
        assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "");
        driver.navigate().refresh();

        driver.findElement(By.tagName("input")).sendKeys("4.47e+8");
        assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "4.47e+8");

        driver.quit();
    }
}