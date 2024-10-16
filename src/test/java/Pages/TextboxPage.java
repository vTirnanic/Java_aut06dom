package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxPage {

    WebDriver driver;
    WebElement fullNameField;
    WebElement emailField;
    WebElement currentAddressField;
    WebElement permanentAddressField;
    WebElement submitButton;
    WebElement outputField;


    public TextboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullNameField() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getCurrentAddressField() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressField() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getOutputField() {
        return driver.findElement(By.id("output"));
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

    public void inputFullName(String fullName) {
        getFullNameField().clear();
        getFullNameField().sendKeys(fullName);
    }

    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        getCurrentAddressField().clear();
        getCurrentAddressField().sendKeys(currentAddress);
    }
    public void inputPermanentAddress(String permanentAddress) {
        getPermanentAddressField().clear();
        getPermanentAddressField().sendKeys(permanentAddress);
    }
}
