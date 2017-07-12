package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by mia on 2017/7/10.
 */
public class Evcard_Welcome_Activity_Android {

    private AndroidElement start_button;
    private AndroidElement text_view;
    private AndroidElement image_view;
    private AndroidElement setting;
    private AndroidDriver<AndroidElement> driver;
    private List<AndroidElement> edit_List;
    private AndroidElement loginbtn ;
    private AndroidElement findSite ;

    public Evcard_Welcome_Activity_Android(AndroidDriver driver){
        this.driver=driver;
    }

    //关闭欢迎页面
    public void Clear(){
        appWait(20000);
        start_button = driver.findElement(By.id("com.baosight.carsharing:id/clear_btn"));
        start_button.click();
    }

    //关闭新手引导
    public void ClostNoviceboot(){
        appWait(7000);
        text_view = driver.findElement(By.id("com.baosight.carsharing:id/scan_tv_know"));
        text_view.click();
        driver.pressKeyCode(4);
        appWait(4000);
    }

    //点击菜单
    public void ClickMenu(){
        image_view=driver.findElement(By.id("com.baosight.carsharing:id/menu_img"));
        image_view.click();
    }

    //点击登录
    public void ClickLogin(){
        setting=driver.findElement(By.id("com.baosight.carsharing:id/ic_setting"));
        setting.click();
    }

    //登录
    public void InputLogin(){
        edit_List=driver.findElementsByClassName("android.widget.EditText");
        edit_List.get(0).clear();
        edit_List.get(0).sendKeys("18800563623");
        edit_List.get(1).clear();
        edit_List.get(1).sendKeys("m1234567");
        loginbtn=driver.findElement(By.id("com.baosight.carsharing:id/loginBtn"));
        loginbtn.click();
    }

    public void FindSite(){
        findSite=driver.findElement(By.id("com.baosight.carsharing:id/center_or_city"));
        findSite.click();
        appWait(10000);
    }

    public void appWait(long time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void swipeToUp(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

    public void swipeToDown(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }

    public void swipeToLeft(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
        // wait for page loading
    }

    public void swipeToRight(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
        // wait for page loading
    }
}
