package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationErrorPage extends AbstractPage {

    private final String XPATH_FOR_LOCATION_MESSAGE_ERROR = "//*[@id=\"wrapper-vue-container\"]/div/div/div[3]/div/div";

    private WebElement locationErrorMessage;

    public LocationErrorPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LocationErrorPage openPage(){
        return this;
    }

    public String getLocationErrorMessage(){
        locationErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_LOCATION_MESSAGE_ERROR)));
        return locationErrorMessage.getText();
    }
}
