package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
/*
Сделать цепочку из действий:
наведение на профиль,
проверка имени,
клик по ссылке,
 проверка что нет 404 ошибки.
 Повторить для каждого из профилей.
 Использовать класс Actions и https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java

 */

public class Hovers {public static final String RESULT = "//input";
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    Actions actions = new Actions(driver);
    @Test
    public void inputsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/hovers");


       // driver.findElement(By.tagName("input")).sendKeys("123");
        //assertEquals(driver.findElement(By.xpath(RESULT)).getAttribute("value"), "123");

        driver.quit();
    }
}
