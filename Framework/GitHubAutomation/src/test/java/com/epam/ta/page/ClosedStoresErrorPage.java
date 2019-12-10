package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClosedStoresErrorPage extends AbstractPage {

    private final String NAME_FOR_CLOSED_STORES_ERROR_MESSAGE = "text_1uyOPEST";

    private WebElement closedStoresErrorMessage;

    public ClosedStoresErrorPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ClosedStoresErrorPage openPage(){
        return this;
    }

    public String getClosedStoresErrorMessage() {
        closedStoresErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.name(NAME_FOR_CLOSED_STORES_ERROR_MESSAGE)));
        return closedStoresErrorMessage.getText();
    }
}
