package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 12:45
 *
 * @author Cheney Wong
 */
public class EvcardMyMessageCenterActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;

    public EvcardMyMessageCenterActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/message_back"));
        layout.click();
    }

    /* click all message */
    public void clickAllMessage()
    {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/all_message"));
        layout.click();
    }

    /* click point message */
    public void clickPointMessage() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/net_message"));
        layout.click();
    }

    /* click order message */
    public void clickOrderMessage() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/order_message"));
        layout.click();
    }

    /* click system message */
    public void clickSystemMessage() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/system_message"));
        layout.click();
    }
}
