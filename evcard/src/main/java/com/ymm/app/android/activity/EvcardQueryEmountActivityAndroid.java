package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 14:46
 *
 * @author Cheney Wong
 */
public class EvcardQueryEmountActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;

    public EvcardQueryEmountActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/weiguoqi_e_back"));
        layout.click();
    }

    /* click ebi expired */
    public void clickEbiExpired() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElementByAndroidUIAutomator("new UiSelector().text(\"查看过期E币\")");
        layout.click();
    }
}
