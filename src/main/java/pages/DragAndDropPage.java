package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public static String url = "http://the-internet.herokuapp.com/drag_and_drop";

    @FindBy(xpath = "//*[@id='column-a']")
    WebElement columnA;
    @FindBy(xpath = "//*[@id='column-b']")
    WebElement columnB;

    public WebElement getColumnA() {
        return columnA;
    }

    public WebElement getColumnB() {
        return columnB;
    }

    public DragAndDropPage openPage() {
        driver.get(url);
        return this;
    }

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }
}