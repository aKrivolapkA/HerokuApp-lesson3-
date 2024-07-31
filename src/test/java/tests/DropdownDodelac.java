package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран

 */
public class DropdownDodelac {
    WebDriver driver = new ChromeDriver();

    @Test
    public void dropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.xpath("//*[@id='dropdown']")).getText();

        //Assert.assertEquals(getDropdownList(), "Please select an option\n    Option 1\n    Option 2\n");



    }

    public String getDropdownList() {
        return driver.findElement(By.xpath("//*[@id='dropdown']")).getText();
    }


}

