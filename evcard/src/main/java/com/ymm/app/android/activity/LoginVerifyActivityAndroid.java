package com.ymm.app.android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by gujie on 2016/10/14.
 */
public class LoginVerifyActivityAndroid {

    private AndroidDriver<AndroidElement> driver;


    private AndroidElement code_button;
    private AndroidElement confirm_button;
    private List<AndroidElement> edit_List;
    private AndroidElement login_button;
    private AndroidElement start_button;


    public LoginVerifyActivityAndroid(AndroidDriver driver){
        this.driver=driver;
    }

    public void startLogin(){
        start_button = driver.findElement(By.id("com.xiwei.logistics:id/logo_container"));
        start_button.click();
    }

    //点击获取验证码按钮
    public void verifycode(){
        code_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"获取验证码\")");
        code_button.click();
    }

    //输入验证码
    public void enterVerifycode(String code){
        edit_List = driver.findElementsByClassName("android.widget.EditText");
        edit_List.get(1).clear();
        edit_List.get(1).sendKeys(code);
    }

    //输入手机号
    public void enterTelephoneNum(String telephoneNum){
        edit_List = driver.findElementsByClassName("android.widget.EditText");
        edit_List.get(0).clear();
        edit_List.get(0).sendKeys(telephoneNum);

    }



    //确认输入验证码
    public void clickConfirm(){
        confirm_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")");
        confirm_button.click();
    }

    //点击登录
    public void clickLogin(){
        login_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登   录\")");
        login_button.click();
    }


    public void swipeToLeft(int during){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 9/10 , height / 2, width /10 , height / 2, during);
    }


    //关闭APP方法
    public void closeApp()
    {
        for(int h=0;h<6;h++)
        {
            driver.pressKeyCode(4);
        }
    }

    //验证activity方法
    public Boolean activityVerify(long time,AndroidDriver<AndroidElement> tdriver,String activity)
    {
       // System.out.println(tdriver.getPageSource());
       // System.out.println(tdriver.currentActivity());
        for(int i=1;i<time/1000;i++){
            appWait(1000);
            if(tdriver.currentActivity().equals(activity))
            {
                return true;
            }
        }
        System.out.println("can not find "+activity);
        return false;
    }

    //线程等待方法
    public void appWait(long time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
