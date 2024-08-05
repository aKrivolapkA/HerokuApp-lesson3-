package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.AlertsPage.exampleText;

public class AlertsTests extends BaseTest {
    @Test
    public void testAcceptAlert() {
        alertsPage.openPage()
                .clickOnAlertButton()
                .acceptAlert();
        Assert.assertEquals(alertsPage.getResult().getText(), "You successfully clicked an alert");
    }

    @Test
    public void testCancelAlert() {
        alertsPage
                .openPage()
                .clickOnConfirmButton()
                .cancelAlert();
        Assert.assertEquals(alertsPage.getResult().getText(), "You clicked: Cancel");
    }

    @Test
    public void testInputInAlert() {
        alertsPage
                .openPage()
                .clickOnPromptButton()
                .inputValue()
                .acceptAlert();
        Assert.assertEquals(alertsPage.getResult().getText(), String.format("You entered: %s", exampleText));
    }
}