package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 13:52
 *
 * @author Cheney Wong
 */
public class EvcardSetUpSystemActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;

    public EvcardSetUpSystemActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/setup_backImg"));
        layout.click();
    }

    /* click modify password */
    public void clickModifyPassword() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/update_pass_btn"));
        layout.click();
    }

    /* click feedback */
    public void clickFeedback() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_feedback"));
        layout.click();
    }

    /* click about */
    public void clickAbout() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/about_version"));
        layout.click();
    }

    /* click logout */
    public void clickLogout() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/login_out"));
        layout.click();
    }
}
