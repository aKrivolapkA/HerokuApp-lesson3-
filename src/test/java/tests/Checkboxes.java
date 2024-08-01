package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
проверить, что первый чекбокс unchecked,
отметить первый чекбокс,
проверить что он checked.
Проверить, что второй чекбокс checked,
сделать unhecked,
 проверить, что он unchecked

 */
public class Checkboxes {

    @Test
    public void firstCheckboxIsUncheckedTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        Assert.assertFalse(driver.findElement(By.xpath("(//input)[1]")).isSelected());


        driver.quit();
    }
    @Test
    public void firstCheckboxIsCheckedTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        driver.findElement(By.xpath("(//input)[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//input)[1]")).isSelected());
        driver.quit();
    }
    @Test
    public void secondCheckboxIsCheckedTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        Assert.assertTrue(driver.findElement(By.xpath("(//input)[2]")).isSelected());
        driver.quit();
    }
    @Test
    public void secondCheckboxIsUncheckedTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        driver.findElement(By.xpath("(//input)[2]")).click();
        Assert.assertFalse(driver.findElement(By.xpath("(//input)[2]")).isSelected());
        driver.quit();
    }
}