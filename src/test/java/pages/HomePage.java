package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//a[@title='find owners']")
    WebElement findOwnersButton;

    public void clickFindOwners() {findOwnersButton.click();}
}
