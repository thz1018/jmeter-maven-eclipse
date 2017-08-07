package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Create on 2017/8/4 13:57
 *
 * @author Cheney Wong
 */
public class EvcardModifyPassActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;
    private List<AndroidElement> editTextList;

    public EvcardModifyPassActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/modify_pass_backImg"));
        layout.click();
    }

    /* fill modify password form */
    public void fillModifyPassForm(List<String> infos) {
        GeneralAppOperation.appWait(1000);
        editTextList = androidDriver.findElementsByClassName("android.widget.EditText");
        for (int i = 0; i < editTextList.size(); i++) {
            editTextList.get(i).clear();
            editTextList.get(i).sendKeys(infos.get(i));
        }
    }

    /* click confirm modification */
    public void clickConfirm() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/linearmodity_pass"));
        textView.click();
    }
}
