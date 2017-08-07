package testcase;

import android.content.Context;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Properties;


public class LoginTest {
    private static Context mContext;
    private AndroidDriver<AndroidElement> driver;

    InputStream inputStream;

    @BeforeTest
    public void setUp() throws Exception {
        Properties properties = new Properties();
        //noinspection Duplicates
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            inputStream = loader.getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app");
        File app = new File(appDir, "evcard_Android_TEST_2_7_0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", properties.getProperty("deviceName","test"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion","test"));
        capabilities.setCapability("udid", properties.getProperty("udid","test"));
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", properties.getProperty("appPackage","test"));
        capabilities.setCapability("appActivity", ".common.ui.MainActivity");
        //capabilities.setCapability("appActivity", ".ui.activity.UPlusMainActivity");
        driver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("url","test")), capabilities);
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        //验证APP启动成功，并且MainActivity打开
        if (activityVerify(8000, driver, ".common.ui.MainActivity")) {

            Assert.assertEquals(driver.currentActivity(), ".common.ui.LoginVerifyActivity");
            AndroidElement code_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"获取验证码\")");
            code_button.click();
            //System.out.println(driver.getPageSource().toString());
            //AndroidElement bt_config = driver.findElementByClassName("android.widget.Button");
            AndroidElement confirm_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"确定\")");
            confirm_button.click();
            appWait(1000);
            List<AndroidElement> edit_List = driver.findElementsByClassName("android.widget.EditText");
            edit_List.get(0).clear();
            edit_List.get(0).sendKeys("3729");
            appWait(1000);
            AndroidElement login_button = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"登   录\")");
            login_button.click();
            Assert.assertEquals(driver.currentActivity().toString(), ".common.ui.CarrierMainActivity");

        }
        //关闭APP
        closeApp();
        //验证APP已经关闭
        Assert.assertNotEquals(driver.currentActivity().toString(), ".carrier.ui.CarrierMainActivity");
        Assert.assertNotEquals(driver.currentActivity().toString(), ".common.ui.WelcomeActivity");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    //线程等待方法
    public void appWait(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //关闭APP方法
    public void closeApp() {
        for (int h = 0; h < 6; h++) {
            driver.pressKeyCode(4);
        }
    }

    //验证activity方法
    public Boolean activityVerify(long time, AndroidDriver<AndroidElement> tdriver, String activity) {
        System.out.println(tdriver.getPageSource());
        System.out.println(tdriver.currentActivity());
        for (int i = 1; i < time / 1000; i++) {
            appWait(1000);
            if (tdriver.currentActivity().equals(activity)) {
                return true;
            }
        }
        System.out.println("can not find " + activity);
        return false;
    }
}
