package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Create on 2017/8/4 14:05
 *
 * @author Cheney Wong
 */
public class EvcardFeedbackActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement editText;
    private AndroidElement layout;
    private AndroidElement textView;

    public EvcardFeedbackActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/backImg"));
        layout.click();
    }

    /* fill feedback */
    public void fillFeedback(String feedback) {
        GeneralAppOperation.appWait(1000);
        editText = androidDriver.findElement(By.id("com.baosight.carsharing:id/feedback_edit"));
        editText.sendKeys(feedback);
    }

    /* click send */
    public void clickSend() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/confirmFeedBack"));
        textView.click();
    }
}
