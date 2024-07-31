package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
/*
роверить содержимое нескольких (3-5) ячеек таблицы. Использовать xpath типа //table//tr[1]//td[1] - получение первой ячейки из первого ряда первой таблицы и так далее

 */
public class SortableDataTables {
    public static final String RESULT = "//input";
    @Test
    public void inputsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/tables");

        assertEquals("Smith",driver.findElement(By.xpath("(//table//tr[1]//td[1])[1]")).getText());
        assertEquals("John",driver.findElement(By.xpath("(//table//tr[1]//td[2])[2]")).getText());
        assertEquals("$100.00",driver.findElement(By.xpath("(//table//tr[3]//td[4])[1]")).getText());
        assertEquals("http://www.timconway.com",driver.findElement(By.xpath("(//table//tr[4]//td[5])[2]")).getText());

        driver.quit();
    }
}
