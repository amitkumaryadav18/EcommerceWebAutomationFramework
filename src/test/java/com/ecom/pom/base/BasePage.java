package com.ecom.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait waitLong;
    protected WebDriverWait waitShort;

    public BasePage(WebDriver driver){
        this.driver = driver;
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(15));
        waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void load(String endPoint){
        driver.get("https://askomdch.com" + endPoint);
    }

    public void waitForOverlayToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE: "+ overlays.size());
        if(!overlays.isEmpty()){
            waitLong.until(
                    ExpectedConditions.invisibilityOfAllElements(overlays)
            );
            System.out.println("OVERLAY ARE INVISIBLE!");
        }
        else{
            System.out.println("OVerlay not found");
        }
    }

    public WebElement waitForElementToBeVisible(By locator){
        return waitShort.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitLongForElementToBeVisible(By locator){
        return waitLong.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator){
        return waitShort.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
