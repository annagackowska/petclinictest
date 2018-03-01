package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.validation.constraints.Max;
import java.util.List;

public class OwnerInformationPage {

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td//b")
    WebElement nameField;

    public String getNameMessage() {
        return nameField.getText();
    }

}
