package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 10:47
 *
 * @author Cheney Wong
 */
public class EvcardYouHuiJuanActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement button;
    private AndroidElement editText;

    public EvcardYouHuiJuanActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/youhuijuan_back"));
        layout.click();
    }

    /* click coupon illustration */
    public void clickIllustration() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/youhuijuan_info_convert_layout"));
        layout.click();
    }

    /* click coupon */
    public void clickCoupon() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/youhuijuan_left_layout"));
        button.click();
    }

    /* click coupon expired */
    public void clickCouponExpired() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/youhuijuan_right_layout"));
        layout.click();
    }

    /* fill coupon code */
    public void fillCouponCode(String couponCode) {
        GeneralAppOperation.appWait(1000);
        editText = androidDriver.findElement(By.id("com.baosight.carsharing:id/ed_yuehuan"));
        editText.sendKeys(couponCode);
    }

    /* click exchange */
    public void clickExchange() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/btn_yuehuan"));
        button.click();
    }
}
