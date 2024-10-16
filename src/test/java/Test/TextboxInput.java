package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextboxInput extends BaseTest {

    private String fullName = "Pera Peric";
    private String validEmail = "pera@hunter.com";
    private String invalidEmail = "pera@com";
    private String currentAddress = "Studentska 28";
    private String permanentAddress = "Perin sokak 5";

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        scrollToElement(homePage.getElementsButton().get(0));
        homePage.clickOnCard("Elements");
        sidebarPage.clickOnButton("Text Box");
    }

    @Test
    public void userCanSubmitWithValidEmail() {
        textboxPage.inputFullName(fullName);
        textboxPage.inputEmail(validEmail);
        textboxPage.inputCurrentAddress(currentAddress);
        textboxPage.inputPermanentAddress(permanentAddress);
        scrollToElement(textboxPage.getSubmitButton());
        textboxPage.clickOnSubmitButton();
        Assert.assertTrue(textboxPage.getOutputField().isDisplayed());
        Assert.assertEquals(textboxPage.getOutputField().findElement(By.id("name")).getText(),
                "Name:" + fullName);
        Assert.assertEquals(textboxPage.getOutputField().findElement(By.id("email")).getText(),
                "Email:" + validEmail);
        Assert.assertEquals(textboxPage.getOutputField().findElement(By.id("currentAddress")).getText(),
                "Current Address :" + currentAddress);
        Assert.assertEquals(textboxPage.getOutputField().findElement(By.id("permanentAddress")).getText(),
                "Permananet Address :" + permanentAddress);
    }

    @Test
    public void userCannotSubmitWithInvalidEmail() {
        textboxPage.inputFullName(fullName);
        textboxPage.inputEmail(invalidEmail);
        textboxPage.inputCurrentAddress(currentAddress);
        textboxPage.inputPermanentAddress(permanentAddress);
        scrollToElement(textboxPage.getSubmitButton());
        textboxPage.clickOnSubmitButton();
        Assert.assertFalse(textboxPage.getOutputField().isDisplayed());
    }
}
