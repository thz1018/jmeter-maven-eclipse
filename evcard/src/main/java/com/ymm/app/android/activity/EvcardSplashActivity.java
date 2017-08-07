package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/3 14:36
 *
 * @author Cheney Wong
 */
public class EvcardSplashActivity {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement button;

    public EvcardSplashActivity(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* skip splash screen */
    public void clickSkipBtn() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/skip_btn"));
        button.click();
    }
}
