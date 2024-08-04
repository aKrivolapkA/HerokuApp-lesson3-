package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage{
    public static String url="http://the-internet.herokuapp.com/javascript_alerts";
    public static String exampleText ="some text";

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement clickForJSAlertButton;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement clickForJSConfirmButton;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement clickForJSPromptButton;

    @FindBy(xpath = " //*[@id='result']")
    WebElement result;

    public WebElement getResult() {
        return result;
    }

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage openPage() {
        driver.get(url);
        return this;
    }
    public AlertsPage clickOnAlertButton(){
        clickForJSAlertButton.click();
        return this;
    }

    public AlertsPage acceptAlert(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    public AlertsPage clickOnConfirmButton(){
        clickForJSConfirmButton.click();
        return this;
    }
    public AlertsPage cancelAlert(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        return this;
    }
    public AlertsPage clickOnPromptButton(){
        clickForJSPromptButton.click();
        return this;
    }

    public AlertsPage inputValue(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Alert alert= wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(exampleText);
        return this;
    }
}