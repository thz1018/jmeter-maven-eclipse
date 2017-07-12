package com.ymm.app.android.performance;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Created by gujie on 2016/10/25.
 */
public class MainActivityAndrod {


    private AndroidDriver<AndroidElement> driver;
    private AndroidElement button;
    private AndroidElement Knowbutton;


    public MainActivityAndrod(AndroidDriver driver){
        this.driver=driver;
    }

    public void switchPage(String id){
        button = driver.findElement(By.id(id));
        button.click();
    }

    public void clickKnow(){
        Knowbutton = driver.findElement(By.id("com.xiwei.logistics:id/btn_title_right_text"));
        Knowbutton.click();
    }



}
