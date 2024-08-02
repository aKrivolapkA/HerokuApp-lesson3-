package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран

 */
public class Dropdown {
    WebDriver driver = new ChromeDriver();

    @Test
    public void allDropdownElementsExistsTest() {
        //собрать все элементы в коллекцию и проверить асертом, что в ней 3 элемента
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        List<WebElement> elements =driver.findElements(By.tagName("option"));
        Assert.assertEquals(elements.size(),3);
        driver.quit();
    }
    @Test
    public void firstDropdownElementSelectedTest() {
        // проверить что первый элемент дропдауна выбран, т.е. выбрать его и проверить например, что текст сейчас отображается из первого дропдауна на страничке
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        Assert.assertEquals("Please select an option", driver.findElement(By.xpath("(//option)[1]")).getText());
        driver.quit();
    }
    @Test
    public void secondDropdownElementSelectedTest() {
        // проверить что 2 элемент дропдауна выбран, т.е. выбрать его и проверить например, что текст сейчас отображается из первого дропдауна на страничке
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        driver.findElement(By.tagName("option")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).click();
        Assert.assertEquals("Option 1", driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).getText());
        driver.quit();
    }
    @Test
    public void thirdDropdownElementSelectedTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        driver.findElement(By.tagName("option")).click();
        driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']")).click();
        Assert.assertEquals("Option 2", driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='2']")).getText());
        driver.quit();
    }
}