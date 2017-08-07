package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 15:53
 *
 * @author Cheney Wong
 */
public class EvcardDepositActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;

    public EvcardDepositActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/dep_back"));
        layout.click();
    }

    /* click credit card */
    public void clickCreditCard() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/item_preauthorization"));
        layout.click();
    }

    /* click online payment */
    public void clickOnlinePayment() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/item_pay"));
        layout.click();
    }
}
