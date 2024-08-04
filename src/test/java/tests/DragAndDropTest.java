package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {
        dragAndDropPage
                .openPage()
                .dragAndDrop();
        Assert.assertEquals(dragAndDropPage.getColumnA().getText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnB().getText(), "A");

    }
}
