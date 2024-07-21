package com.ecom.pom;

import com.ecom.pom.base.BaseTest;
import com.ecom.pom.objects.BillingAddress;
import com.ecom.pom.objects.Product;
import com.ecom.pom.objects.User;
import com.ecom.pom.pages.*;
import com.ecom.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuyAndCheckoutFlowTests extends BaseTest {


    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {
        //BillingAddress billingAddress = BillingAddress.builder().build();
        String searchFor = "Blue";
        BillingAddress billingAddress  = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = Product.fetchProduct(1215);

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clickStoreMenuLink();
        // Structural approach
        /*storePage.
                enterTextInSearchField("Blue").
                clickSearchBtn();*/
        // functional approach
        storePage.isLoaded();
        storePage.search(searchFor);

        Assert.assertEquals(storePage.getTitle(),"Search results: “" +searchFor +"”");
        storePage.clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.clickViewCartLink();
        cartPage.isLoaded();

        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutPage().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                clickPlaceOrderBtn();

        Assert.assertEquals(checkoutPage.getNoticeMsg(),
                "Thank you. Your order has been received.");

    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException {
        String searchFor = "Blue";
        BillingAddress billingAddress  = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = Product.fetchProduct(1215);
        User user = JacksonUtils.deserializeJson("user.json", User.class);

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.clickStoreMenuLink();
        storePage.isLoaded();
        storePage.search(searchFor);

        Assert.assertEquals(storePage.getTitle(),"Search results: “" +searchFor +"”");
        storePage.clickAddToCartBtn(product.getName());
        CartPage cartPage = storePage.clickViewCartLink();
        cartPage.isLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickCheckoutPage();

        // login

        LoginPage loginPage = checkoutPage.clickLoginBtn();
        CheckoutPage checkoutPageAfterLogin = loginPage.login(user);

        // details

        checkoutPageAfterLogin.setBillingAddress(billingAddress);
        checkoutPageAfterLogin.selectDirectBankTransfer();
        checkoutPageAfterLogin.clickPlaceOrderBtn();

        Assert.assertEquals(checkoutPageAfterLogin.getNoticeMsg(),
                "Thank you. Your order has been received.");
    }
}
