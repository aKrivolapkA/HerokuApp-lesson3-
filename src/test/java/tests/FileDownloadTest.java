package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileDownloadPage;

public class FileDownloadTest extends BaseTest {
    @Test
    public void fileDownloadTest() throws InterruptedException {
        FileDownloadPage test = new FileDownloadPage();
        test.download();
        test.check();
        Assert.assertTrue(test.found, "Downloaded document is not found");
        test.f.deleteOnExit();
    }
}
