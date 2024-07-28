package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;

public class AddRemoveElements {
    @Test
    public void addRemoveElements(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        List<WebElement> elements= driver.findElements(By.xpath("//button[text()='Delete']"));
        if(elements.size()==1){
            System.out.println("на страницы одна кнопка- тест позитивный ");
        }else {
            System.exit(2);
        }
        driver.quit();

    }

}
