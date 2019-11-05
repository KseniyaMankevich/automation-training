import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final String HOMEPAGE_URL = "https://www.rentcars.com/en/";
    private final int WAIT_TIMEOUT_SECONDS = 20;

    public WebDriver driver;
    public WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }


    @FindBy(xpath = "//*[@id=\"dropdown-offline\"]/span")
    private WebElement logInSignUpButton;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[1]/div/div/input")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[2]/div/div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]/div[1]/div[2]/div/div/div[2]/div/ul/li[4]/form/div[3]/input")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"client\"]/div[2]/div[1]/div/div/span")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"SuggestPickup\"]")
    private WebElement pickUpCityInput;

    @FindBy(xpath = "//*[@id=\"DataRetirada\"]")
    private WebElement pickUpDateInput;

    @FindBy(xpath = "//*[@id=\"DataDevolucao\"]")
    private WebElement dropOffDateInput;

    @FindBy(xpath = "//*[@id=\"HoraRetirada\"]")
    private WebElement pickUpTimeInput;

    @FindBy(xpath = "//*[@id=\"HoraDevolucao\"]")
    private WebElement dropOffTimeInput;

    @FindBy(xpath = "//*[@id=\"DataDevolucao-error\"]")
    private WebElement dateErrorMessage;

    @FindBy(className = "available")
    private WebElement dateChoice;


    public HomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }


    public HomePage openLoginPage() {
        logInSignUpButton.click();
        return this;
    }


    public HomePage loginToWebSite (String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }


    public void checkUser (String expectedMessage) {
        Assert.assertTrue(loginErrorMessage.getText().equals(expectedMessage));
    }


    public HomePage enterRentInfo (String pickUpCity,  String pickUpTime, String dropOffTime) {
        pickUpCityInput.sendKeys(pickUpCity);
        pickUpDateInput.click();
        dateChoice.click();
        pickUpTimeInput.sendKeys(pickUpTime);
        dropOffDateInput.click();
        dateChoice.click();
        dropOffTimeInput.sendKeys(dropOffTime);
        return this;
    }


    public void checkDate (String expectedMessage) {
        Assert.assertTrue(dateErrorMessage.getText().equals(expectedMessage));
    }
}
