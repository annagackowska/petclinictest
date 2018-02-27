package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.validation.constraints.Max;
import java.util.List;

public class OwnerInformationPage {


    @FindBy(xpath = "//table[@id='vets']//tbody")
    WebElement ownerTable;

    public String containsUser() {
        return ownerTable.getText();
    }

    public String containsOfOwnerTable() {

        List<WebElement> rows = ownerTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {

            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                return (col.getText());
            }
        }
        return (ownerTable.getText());
    }
}
