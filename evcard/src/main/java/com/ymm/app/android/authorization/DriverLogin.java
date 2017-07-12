package com.ymm.app.android.authorization;

import com.ymm.app.android.activity.LoginVerifyActivityAndroid;
import com.ymm.app.android.activity.SplashActivityAndroid;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * Created by gujie on 2016/10/21.
 */
public class DriverLogin {


    private AndroidDriver<AndroidElement> driver;
    private LoginVerifyActivityAndroid loginVerifyActivityAndroid;
    private SplashActivityAndroid splashActivityAndroid;
    private WebDriverWait driverWait;


    public DriverLogin(AndroidDriver driver, String telephoneNum, String code) {

        this.driver=driver;

        this.loginVerifyActivityAndroid=new LoginVerifyActivityAndroid(this.driver);
        this.splashActivityAndroid=new SplashActivityAndroid(this.driver);


        if(loginVerifyActivityAndroid.activityVerify(8000, driver, ".splash.SplashActivity")==true) {
            //app引导页切换
            int n = 0;
            while (n < 5) {
                loginVerifyActivityAndroid.swipeToLeft(10000);
                n = n + 1;
                if (n >= 2) {
                    loginVerifyActivityAndroid.startLogin();
                    Assert.assertEquals(driver.currentActivity().toString(), ".splash.SplashActivity");
                    Assert.assertTrue(driver.getPageSource().toString().contains("登录"));
                    break;
                }
            }
        }

        //验证APP启动成功，并且MainActivity打开
        if(loginVerifyActivityAndroid.activityVerify(8000, driver, ".splash.SplashActivity")==true)
        {

            splashActivityAndroid.login();
            Assert.assertEquals(driver.currentActivity().toString(), ".common.ui.LoginVerifyActivity");
            loginVerifyActivityAndroid.enterTelephoneNum(telephoneNum);
            loginVerifyActivityAndroid.appWait(1000);

            loginVerifyActivityAndroid.verifycode();
            loginVerifyActivityAndroid.appWait(1000);

            loginVerifyActivityAndroid.clickConfirm();
            loginVerifyActivityAndroid.appWait(1000);

            loginVerifyActivityAndroid.enterVerifycode(code);
            loginVerifyActivityAndroid.appWait(1000);

            loginVerifyActivityAndroid.clickLogin();
            //new PerformanceUtil(driver, "即时货源页面响应时间", "com.xiwei.logistics:id/btn_start_sub");
            loginVerifyActivityAndroid.appWait(1000);


            Assert.assertEquals(driver.currentActivity().toString(), ".carrier.ui.CarrierMainActivity");

        }

    }

}
