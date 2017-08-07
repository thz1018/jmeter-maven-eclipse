package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/3 17:35
 *
 * @author Cheney Wong
 */
public class EvcardUserInfoUploadActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement button;

    public EvcardUserInfoUploadActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/user_upload_back"));
        layout.click();
    }

    /* click customer service */
    public void clickCustomerService() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/submit_jiazhao"));
        button.click();
    }
}
