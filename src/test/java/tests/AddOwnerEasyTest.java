package tests;


import org.assertj.core.api.Assertions;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
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



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "src/test/resources/addowner.xml" }, loaderType = LoaderType.XML, writeData = false)

public class AddOwnerEasyTest {

    private static final String URL = "http://localhost:8080/owners/find";

    private WebDriver driver;

    private FindPage findPage;
    private NewOwnerPage newOwnerPage;
    private OwnerInformationPage ownerInformationPage;

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
    public void addNewOwnerTest(@Param(name = "firstName") String firstName,
                                 @Param(name = "lastName") String lastName,
                                 @Param(name = "address") String address,
                                 @Param(name = "city") String city,
                                 @Param(name = "telephone") String telephone,
                                 @Param(name = "nameField") String nameField) {

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











