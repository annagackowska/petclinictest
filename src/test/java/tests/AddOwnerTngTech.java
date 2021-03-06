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



public class AddOwnerTngTech {

    @RunWith(DataProviderRunner.class)
    public static class AddNewOwner {

        private static final String URL = "http://localhost:8080/owners/find";

        private WebDriver driver;

        private FindPage findPage;
        private NewOwnerPage newOwnerPage;
        private OwnerInformationPage ownerInformationPage;


        @DataProvider
        public static Object[][] testAddNewOwner() {
            return new String[][]{
                new String[]{"Jan", "Kowalski", "Jabloniowa 3", "Gdansk", "555555555", "Jan Kowalski"},
                new String[]{"Ada", "Kruk", "Jabloniowa 4", "Gdynia", "111222333", "Ada Kruk"},
                new String[]{"Tom", "Kret", "Hery 1", "Sopot", "333444555", "Tom Kret"},
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
        @UseDataProvider("testAddNewOwner")
        public void addNewOwner(String firstName, String lastName, String address, String city, String telephone, String nameField) {

            findPage.clickOnAddOwnerButton();

            newOwnerPage.inputOwnerInformation(firstName, lastName, address, city,telephone);

            newOwnerPage.clickOnNewOwnerButton();

            Assertions.assertThat(ownerInformationPage.getNameMessage()).contains(nameField);

        }

        @After
        public void tearDown() {
            driver.close();
        }

    }
}
