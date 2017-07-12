package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Created by gujie on 2016/10/20.
 */
public class SplashActivityAndroid {

    private AndroidDriver<AndroidElement> driver;


    private AndroidElement register_button;
    private AndroidElement login_button;


    public SplashActivityAndroid(AndroidDriver driver){
        this.driver=driver;
    }


    //点击登录按钮
    public void login(){
        login_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登录\")");
        login_button.click();
    }

    //点击注册的按钮
    public void register(){
        register_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"注册\")");
        register_button.click();
    }

}
