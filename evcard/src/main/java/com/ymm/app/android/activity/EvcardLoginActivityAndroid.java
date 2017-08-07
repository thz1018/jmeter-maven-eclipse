package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Create on 2017/8/3 15:18
 *
 * @author Cheney Wong
 */
public class EvcardLoginActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private List<AndroidElement> editTextList;
    private AndroidElement button;

    public EvcardLoginActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* fill the login info blanks */
    public void fillInfo(List<String> infos) {
        GeneralAppOperation.appWait(1000);
        editTextList = androidDriver.findElementsByClassName("android.widget.EditText");
        for (int i = 0; i < editTextList.size(); i++) {
            editTextList.get(i).clear();
            editTextList.get(i).sendKeys(infos.get(i));
        }
    }

    /* click login */
    public void clickLogin() {
        GeneralAppOperation.appWait(3000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/loginBtn"));
        button.click();
    }
}
