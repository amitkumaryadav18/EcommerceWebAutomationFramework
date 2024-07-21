package com.ecom.pom.pages;

import com.ecom.pom.base.BasePage;
import com.ecom.pom.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By userNameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String txt){
        WebElement elementRef = waitForElementToBeVisible(userNameFld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public LoginPage enterPassword(String txt){
        WebElement elementRef = waitForElementToBeVisible(passwordFld);
        elementRef.clear();
        elementRef.sendKeys(txt);
        return this;
    }
    public CheckoutPage login(){
        waitForElementToBeClickable(loginBtn).click();
        return new CheckoutPage(driver);
    }
    public CheckoutPage login(User user){
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        waitForElementToBeClickable(loginBtn).click();
        return new CheckoutPage(driver);
    }
}
