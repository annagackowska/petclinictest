package tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FindPage;
import pages.NewOwnerPage;
import pages.OwnerInformationPage;
import utils.drivers.WebDriverCreators;
import utils.drivers.WebDriverProvider;

public class FindOwnerTngTest {

    @RunWith(DataProviderRunner.class)
    public static class FindOwner {

        private static final String URL = "http://localhost:8080/owners/find";

        private WebDriver driver;

        private FindPage findPage;
        private NewOwnerPage newOwnerPage;
        private OwnerInformationPage ownerInformationPage;


        @DataProvider
        public static Object[][] testFindOwner() {
            return new String[][]{
                new String[]{"Franklin", "George Franklin"},
                new String[]{"Rodriquez", "Eduardo Rodriquez"},
                new String[]{"McTavish", "Peter McTavish"},
            };
        }

        @Before
        public void setUp() {

            driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();

            driver.manage().window().maximize();

            findPage = PageFactory.initElements(driver,FindPage.class);
            newOwnerPage = PageFactory.initElements(driver,NewOwnerPage.class);
            ownerInformationPage = PageFactory.initElements(driver, OwnerInformationPage.class);

            driver.get(URL);

        }

        @Test
        @UseDataProvider("testFindOwner")
        public void findOwner(String lastName, String nameField) {

            findPage.inputOwnerInformation(lastName);

            findPage.clickOnFindOwnerButton();

            Assertions.assertThat(ownerInformationPage.getNameMessage()).contains(nameField);

        }

        @After
        public void tearDown() {
            driver.close();
        }

    }
}

