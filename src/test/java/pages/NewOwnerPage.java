package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

public class NewOwnerPage {

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='address']")
    WebElement addressField;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='telephone']")
    WebElement telephoneField;

    @FindBy(xpath = "//button[@class='btn btn-default'][@type='submit']")
    WebElement addNewOwnerButton;

    public void inputOwnerInformation(String firstName, String lastName, String address, String city, String telephone) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        telephoneField.sendKeys(telephone);

    }

    public void clickOnNewOwnerButton() {addNewOwnerButton.click();}


}
