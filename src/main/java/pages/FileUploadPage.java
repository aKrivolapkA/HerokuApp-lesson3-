package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {
    public static String url = "http://the-internet.herokuapp.com/upload";
    public String filePath = "//Users//alena//Desktop//Notatnik//output.zip";

    @FindBy(xpath = "//*[@id = 'file-upload']")
    WebElement choseFileButton;

    @FindBy(xpath = "//*[@id = 'file-submit']")
    WebElement uploadButton;

    @FindBy(xpath = "//*[@id = 'uploaded-files']")
    public WebElement nameFileField;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public FileUploadPage openPage() {
        driver.get(url);
        return this;
    }

    public FileUploadPage clickUploadButton() {
        uploadButton.click();
        return this;
    }

    public FileUploadPage uploadFile() {
        WebElement uploadElement = choseFileButton;
        uploadElement.sendKeys(filePath);
        return this;
    }
}