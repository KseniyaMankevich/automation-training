import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomePageTest  {
    private WebDriver driver;
    private HomePage homePage;


    @BeforeClass
    public void setUpDriver () {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownDriver () {
        driver.quit();
        driver = null;
    }


    @Test
    public void invalidRentDateTest() {
        homePage.openHomePage()
                .enterRentInfo("Minsk, Belarus", "10:00 AM", "07:00 AM");
                 Assert.assertTrue(homePage.isRentErrorMessageVisible());
    }


    @Test
    public void invalidUserNameInvalidPasswordTest() {
        homePage.openHomePage()
                .openLoginPage()
                .loginToWebSite("safenav363@dmail1.net", "1234");
                 Assert.assertTrue(homePage.isLoginErrorMessageVisible());
    }
}
