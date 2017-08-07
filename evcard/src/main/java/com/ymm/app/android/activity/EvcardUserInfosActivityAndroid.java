package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/3 16:46
 *
 * @author Cheney Wong
 */
public class EvcardUserInfosActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;

    public EvcardUserInfosActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back layout */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/backImg"));
        layout.click();
    }

    /* click modify phone */
    public void clickModifyPhone() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/modifyphone"));
        layout.click();
    }

    /* click identification */
    public void clickIdentification() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/displayName_ll"));
        layout.click();
    }

    /* click progress query */
    public void clickProgressQuery() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/manager_process"));
        layout.click();
    }

    /* click customer service */
    public void clickCustomerService() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/contactsphone"));
        textView.click();
    }
}
