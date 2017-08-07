package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Create on 2017/8/4 9:09
 *
 * @author Cheney Wong
 */
public class EvcardMakeInvoiceActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement checkbox;
    private AndroidElement textView;
    private AndroidElement button;
    private AndroidElement layout;

    public EvcardMakeInvoiceActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click checkbox order */
    public void clickCheckboxOrder() {
        GeneralAppOperation.appWait(1000);
        checkbox = androidDriver.findElement(By.id("com.baosight.carsharing:id/checkbox_order"));
        checkbox.click();
    }

    /* click checkbox ebi*/
    public void clickCheckboxEbi() {
        GeneralAppOperation.appWait(1000);
        checkbox = androidDriver.findElement(By.id("com.baosight.carsharing:id/checkbox_ebi"));
        checkbox.click();
    }

    /* click checkbox checkAll*/
    public void clickCheckboxCheckAll() {
        GeneralAppOperation.appWait(1000);
        checkbox = androidDriver.findElement(By.id("com.baosight.carsharing:id/checkbox_checkall"));
        checkbox.click();
    }

    /* click customer service */
    public void clickCustomerService() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/tv_phone"));
        textView.click();
    }

    /* click invoice history */
    public void clickInvoiceHistory() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/tv_invcice_history"));
        textView.click();
    }

    /* click next step */
    public void clickNextStep() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/btn_nextstep"));
        button.click();
    }

    /* click illustration */
    public void clickIllustration() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/tv_invoice_illustrate"));
        textView.click();
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/invcice_back"));
        layout.click();
    }
}
