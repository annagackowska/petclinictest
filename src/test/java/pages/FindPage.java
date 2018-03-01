package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPage {

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement addOwnerButton;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement findOwnerButton;

    public void clickOnAddOwnerButton() {addOwnerButton.click();}
    public void sendNameField(){lastNameField.sendKeys();}

    public void clickOnFindOwnerButton() {findOwnerButton.click();}

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td//b")
    WebElement nameField;

    public void inputOwnerInformation(String lastName) { lastNameField.sendKeys(lastName); }


}
