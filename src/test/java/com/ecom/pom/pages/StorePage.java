package com.ecom.pom.pages;

import com.ecom.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isLoaded(){
        return waitLong.until(ExpectedConditions.urlContains("/store"));

    }

    public StorePage enterTextInSearchField(String txt){
        waitForElementToBeVisible(searchField).sendKeys(txt);
        return this;
    }
    public StorePage clickSearchBtn(){
        driver.findElement(searchButton).click();
        return this;
    }
    public StorePage search(String txt){
        enterTextInSearchField(txt).clickSearchBtn();
        return this;
    }

    public String getTitle(){
        return waitForElementToBeVisible(title).getText();
    }
    private By getCartBtn(String itemName){
        return By.cssSelector("a[aria-label='Add “" +itemName + "” to your cart']");
    }
    public StorePage clickAddToCartBtn(String itemName){
        By elementRef = getCartBtn(itemName);
        waitForElementToBeClickable(elementRef).click();
        return this;
    }

    public CartPage clickViewCartLink(){
        waitForElementToBeClickable(viewCartLink).click();
        return new CartPage(driver);
    }
}
