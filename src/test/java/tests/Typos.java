package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
/*
Проверить соответствие параграфа орфографии

 */
public class Typos {

    public static final String TEXT="This example demonstrates a typo being introduced. It does it randomly on each page load.";
    public static final String TEXT2="Sometimes you'll see a typo, other times you won't.";
    @Test
    public void typesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/typos");


        assertEquals(TEXT,driver.findElement(By.xpath("//*[contains(text(),'This')]")).getText());
        assertEquals(TEXT2,driver.findElement(By.xpath("//*[contains(text(),'you')]")).getText());
        driver.quit();
    }
}