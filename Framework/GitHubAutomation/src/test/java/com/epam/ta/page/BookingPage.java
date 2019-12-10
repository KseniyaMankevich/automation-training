package com.epam.ta.page;

import com.epam.ta.model.Booking;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends AbstractPage {

    @FindBy(name = "Email")
    private WebElement usernameInput;

    @FindBy(name = "Reserva")
    private WebElement bookingCodeInput;


    @FindBy(xpath = "//*[@id=\"clientLogin\"]")
    private WebElement checkBookingButton;

    private final String XPATH_FOR_BOOKING_ERROR = "//*[@id=\"formGuestMenu\"]/div[3]";
    private WebElement bookingErrorMessage;

    public BookingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BookingPage openPage(){
        return this;
    }

    public String getErrorMessage(Booking bookingInformation){
        inputBookingInformation(bookingInformation);
        bookingErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_BOOKING_ERROR)));
        return bookingErrorMessage.getText();
    }

    public void inputBookingInformation (Booking bookingInformation){
        usernameInput.sendKeys(bookingInformation.getUsername());
        bookingCodeInput.sendKeys(bookingInformation.getBookingCode());
        checkBookingButton.click();
    }
}
