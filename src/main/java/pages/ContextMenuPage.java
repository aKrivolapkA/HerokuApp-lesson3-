package pages;



import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ContextMenuPage extends BasePage{
    public static String popUpText="You selected a context menu";
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }
    ContextMenuPage contextMenuPage;
    public ContextMenuPage openPage() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        return this;
    }

    @FindBy(css = "#hot-spot")
    WebElement elementClick;

    @FindBy(xpath = "//*[@id='content']")
    WebElement someRandomeElement;


    public void clickElement(){
        Actions actions = new Actions(driver);
        actions.contextClick(elementClick).perform();
    }
    public String getText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    public ContextMenuPage acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }
    public boolean isRandomeElementDisplayed() {
        return someRandomeElement.isDisplayed();
    }

}
