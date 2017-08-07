package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 14:54
 *
 * @author Cheney Wong
 */
public class EvcardQueryGuoQiEmountActivityAndroid {
    private AndroidDriver<AndroidElement>androidDriver;
    private AndroidElement layout;

    public EvcardQueryGuoQiEmountActivityAndroid(AndroidDriver androidDriver){
        this.androidDriver=androidDriver;
    }

    /* click back */
    public void clickBack(){
        GeneralAppOperation.appWait(1000);
        layout=androidDriver.findElement(By.id("com.baosight.carsharing:id/guoqi_e_back"));
        layout.click();
    }
}
