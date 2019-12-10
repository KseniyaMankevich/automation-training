package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(name = "Email")
    private WebElement usernameInput;

    @FindBy(xpath = "Senha")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"clientLogin\"]")
    private WebElement loginButton;


    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage(){
        return this;
    }

    public LoginErrorPage redirectToLoginPageError(User userInformation){
        loginToWebSite(userInformation);
        return new LoginErrorPage(driver);
    }

    public void loginToWebSite (User userInformation){
        usernameInput.sendKeys(userInformation.getUsername());
        passwordInput.sendKeys(userInformation.getPassword());
        loginButton.click();
    }
}
