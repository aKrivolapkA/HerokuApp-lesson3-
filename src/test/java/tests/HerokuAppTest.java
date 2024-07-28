package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HerokuAppTest {

    @Test
    public void inputTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// ждать на поиск каждого элемента
        //работа с куки
        //Cookie cookie= new Cookie("dsdf","dddd");
        //driver.manage().addCookie(cookie);

        //System.out.println(driver.getWindowHandle()); получить значение влкдаки соседней
        WebElement inputField = driver.findElement(By.xpath("//*[@type='number']"));
        inputField.sendKeys("20");
        String actualText= inputField.getAttribute("value");
        Assert.assertEquals(actualText,"20");

        inputField.sendKeys(Keys.ARROW_UP);// стрелка
        String actualText1= inputField.getAttribute("value");
        Assert.assertEquals(actualText1,"21");
driver.quit();


    }
}
