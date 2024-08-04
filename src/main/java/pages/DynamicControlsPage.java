package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    public static String url = "http://the-internet.herokuapp.com/dynamic_controls";

    @FindBy(xpath = "//*[@id ='checkbox']//input")
    public WebElement checkbox;

    @FindBy(xpath = "//button[@autocomplete='off' and text()='Remove']")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id='message']")
    WebElement messageText;

    @FindBy(xpath = "//input[@type='text']")
    WebElement inputField;
    @FindBy(xpath = "//button[@autocomplete='off' and text()='Enable']")
    WebElement enableButton;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage openPage() {
        driver.get(url);
        return this;
    }

    public DynamicControlsPage clickCheckbox() {
        checkbox.click();
        return this;
    }

    public DynamicControlsPage clickRemoveButton() {
        removeButton.click();
        return this;
    }

    public boolean isElementInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        return wait.until(ExpectedConditions.invisibilityOf(checkbox));
    }

    public boolean isInputFieldDisable() {
        return inputField.isEnabled();
    }

    public DynamicControlsPage clickOnEnableButton() {
        enableButton.click();
        return this;
    }

    public DynamicControlsPage waitUntilVisible(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(messageText, text));
        return this;
    }
}