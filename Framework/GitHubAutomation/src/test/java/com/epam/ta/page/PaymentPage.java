package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.ta.util.StringUtils.NEW_PICK_UP_LOCATION;

public class PaymentPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"collapse-itinerary\"]/div[1]/div[1]/div[2]")
    private WebElement pickUpLocationInput;


    public PaymentPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PaymentPage openPage(){
        return this;
    }

    public String getNewPickUpLocation(){
        pickUpLocationInput.sendKeys(NEW_PICK_UP_LOCATION);
        return pickUpLocationInput.getText();
    }
}
