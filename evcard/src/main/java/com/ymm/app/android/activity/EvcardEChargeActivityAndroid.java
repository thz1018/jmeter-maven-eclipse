package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 10:34
 *
 * @author Cheney Wong
 */
public class EvcardEChargeActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement layout;
    private AndroidElement textView;
    private AndroidElement editText;

    public EvcardEChargeActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/cash_back"));
        layout.click();
    }

    /* fill recharging amount */
    public void fillRecharingAmount(String rechargingAmount) {
        GeneralAppOperation.appWait(1000);
        editText = androidDriver.findElement(By.id("com.baosight.carsharing:id/accountBalancecash"));
        editText.sendKeys(rechargingAmount);
    }

    /* click Alipay */
    public void clickAlipay() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_alipay_rl"));
        layout.click();
    }

    /* click Wechat */
    public void clickWechat() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_weixin_rl"));
        layout.click();
    }

    /* click Unibank */
    public void clickUnibank() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_bank_rl"));
        layout.click();
    }

    /* click recharge */
    public void clickRecharge() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/recharge"));
        textView.click();
    }
}
