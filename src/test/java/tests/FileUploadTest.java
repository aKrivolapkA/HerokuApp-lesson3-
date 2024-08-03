package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
Загрузить файл
Проверить, что имя файла на странице совпадает с именем загруженного файла
 */
public class FileUploadTest extends BaseTest {
    @Test
    public void test3() {
        fileUploadPage
                .openPage()
                .uploadFile()
                .clickUploadButton();
        Assert.assertEquals(fileUploadPage.nameFileField.getText(), "output.zip");
    }
}