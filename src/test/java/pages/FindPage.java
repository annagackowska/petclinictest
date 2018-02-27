package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPage {

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement addOwnerButton;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    public void clickOnAddOwnerButton() {addOwnerButton.click();}
    public void sendNameField(){lastNameField.sendKeys();}


}
