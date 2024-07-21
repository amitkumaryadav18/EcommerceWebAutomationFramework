package com.ecom.pom.pages;

import com.ecom.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    // Page object method
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");

    private final By cartHeading = By.cssSelector(".has-text-align-center");

    // Page factory method
    /*
    @FindBy(css ="td[class='product-name'] a") private WebElement productName;
    @FindBy(css = HOW.CSS, using = ".checkout-button") private WebElement checkoutBtn;
    */


    public CartPage(WebDriver driver) {
        super(driver);

        // Req for page factory method to work
        //PageFactory.initElements(driver,this);  // --> can be moved to baseclass if used on all pages
    }
    public Boolean isLoaded(){
        return waitLong.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
    }

    public String getProductName(){
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
        //return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckoutPage(){
        waitShort.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        //driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }

}
