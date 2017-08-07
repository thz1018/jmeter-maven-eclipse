package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 10:11
 *
 * @author Cheney Wong
 */
public class EvcardWalletActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;

    public EvcardWalletActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click balance */
    public void clickBalance() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/despit_11_green"));
        layout.click();
    }

    /* click ebi charge */
    public void clickEbiCharge() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/e_charge"));
        layout.click();
    }

    /* click deposit */
    public void clickDeposit() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/cash_rl"));
        layout.click();
    }

    /* click coupon */
    public void clickCoupon() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/youhuijuan_rl"));
        layout.click();
    }

    /* click cost illustration */
    public void clickCostIllustration() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/cost_declare"));
        layout.click();
    }

    /* click invoice */
    public void clickInvoice() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ry_invoice"));
        layout.click();
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/recordback"));
        layout.click();
    }

    /* click history */
    public void clickHistory() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/history_title"));
        layout.click();
    }
}
