package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginErrorPage extends AbstractPage {

    private final String XPATH_FOR_LOGIN_ERROR = "//*[@id=\"loginError\"]";

    private WebElement loginErrorMessage;

    public LoginErrorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginErrorPage openPage(){
        return this;
    }

    public String getLoginErrorMessage(){
        loginErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_LOGIN_ERROR)));
        return loginErrorMessage.getText();
    }
}
