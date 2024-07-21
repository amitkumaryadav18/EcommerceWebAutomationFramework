package com.ecom.pom.pages;

import com.ecom.pom.base.BasePage;
import com.ecom.pom.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By billingFNameFld = By.id("billing_first_name");
    private final By billingLNameFld = By.id("billing_last_name");
    private final By billingAddress_1Fld = By.id("billing_address_1");
    private final By billingAddress_2Fld = By.id("billing_address_2");
    private final By billingCity = By.id("billing_city");
    private final By billingPostcode = By.id("billing_postcode");
    private final By billingEmail = By.id("billing_email");
    private final By placeOrder = By.id("place_order");
    private final By noticeTxt = By.cssSelector(".woocommerce-notice");
    private final By countryDropdown = By.id("billing_country");
    private final By stateDropdown = By.id("billing_state");
    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    private final By loginPageBtn = By.className("showlogin");

    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFName(String txt){

        // Note: If clear action refreshes the DOM then separate waits are required

        WebElement elementRef = waitForElementToBeVisible(billingFNameFld);

        //WebElement elementRef = driver.findElement(billingFNameFld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage enterBillingLName(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingLNameFld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }

    public CheckoutPage selectCountry(String countryName){
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText(countryName);
        return this;
    }

    public CheckoutPage selectState(String state){
        Select select = new Select(waitLongForElementToBeVisible(stateDropdown));
        select.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingAddress_1Fld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage enterBillingAddressTwo(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingAddress_2Fld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage enterBillingCity(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingCity);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage enterBillingPostcode(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingPostcode);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage enterBillingEmail(String txt){
        WebElement elementRef = waitForElementToBeVisible(billingEmail);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage clickPlaceOrderBtn(){
        waitForOverlayToDisappear(overlay);

        driver.findElement(placeOrder).click();
        return this;
    }

    public String getNoticeMsg(){
        return waitLongForElementToBeVisible(noticeTxt).getText();
    }

    public LoginPage clickLoginBtn(){
        waitForElementToBeClickable(loginPageBtn).click();
        return new LoginPage(driver);
    }

    public CheckoutPage selectDirectBankTransfer(){
        WebElement e = waitShort.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterBillingFName(billingAddress.getFirstName()).
                enterBillingLName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                selectState(billingAddress.getState()).
                enterBillingAddressOne(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                enterBillingPostcode(billingAddress.getPostalCode()).
                enterBillingEmail(billingAddress.getEmail());
    }
}
