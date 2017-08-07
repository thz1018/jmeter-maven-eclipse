package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 9:01
 *
 * @author Cheney Wong
 */
public class EvcardMyRecordActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;
    private AndroidElement imageView;

    public EvcardMyRecordActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click undo order */
    public void clickUndo() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/type_undo"));
        layout.click();
    }

    /* click done order */
    public void clickDone() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/type_done"));
        layout.click();
    }

    /* click all order */
    public void clickAll() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/type_all"));
        layout.click();
    }

    /* click invoice */
    public void clickInvoice() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/tv_order_invoice"));
        textView.click();
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        imageView = androidDriver.findElement(By.id("com.baosight.carsharing:id/record_back"));
        imageView.click();
    }
}
