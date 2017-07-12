package testcase;

import com.ymm.app.android.activity.SplashActivityAndroid;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * Created by gujie on 2016/10/20.
 */
public class Test {

    private AndroidDriver<AndroidElement> driver;
    private SplashActivityAndroid splashActivityAndroid;
    @BeforeTest
    public void setUp() throws Exception{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","udid");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("udid", "c03b27ea");
        capabilities.setCapability("appPackage", "com.xiwei.logistics");
        capabilities.setCapability("appActivity", ".common.ui.WelcomeActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @org.testng.annotations.Test
    public void test() throws UnsupportedEncodingException {

        this.splashActivityAndroid=new SplashActivityAndroid(this.driver);
        splashActivityAndroid.login();
        System.out.println(driver.getPageSource());
        System.out.println(driver.currentActivity());


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}


