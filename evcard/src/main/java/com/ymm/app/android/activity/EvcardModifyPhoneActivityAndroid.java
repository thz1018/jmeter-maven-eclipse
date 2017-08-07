package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/3 16:54
 *
 * @author Cheney Wong
 */
public class EvcardModifyPhoneActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;
    private AndroidElement editText;

    public EvcardModifyPhoneActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/phone_back"));
        layout.click();
    }

    /* click next */
    public void clickNext() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/next"));
        textView.click();
    }

    /* fill new phone */
    public void fillNewPhone(String newPhone) {
        GeneralAppOperation.appWait(1000);
        editText = androidDriver.findElement(By.id("com.baosight.carsharing:id/phoneinput"));
        editText.sendKeys(newPhone);
    }
}
