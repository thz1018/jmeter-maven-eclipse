package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 10:41
 *
 * @author Cheney Wong
 */
public class EvcardCashPledgesItmsActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;

    public EvcardCashPledgesItmsActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/recordback"));
        layout.click();
    }

    /* click normal deposit */
    public void clickNormalDeposit() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/rl_item1"));
        layout.click();
    }

    /* click premium deposit */
    public void clickPremiumDeposit() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/rl_item2"));
        layout.click();
    }
}
