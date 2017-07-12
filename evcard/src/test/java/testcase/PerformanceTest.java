package testcase;

import com.datadriver.AutoDataDriverBase;
import com.tools.PerformanceUtil;
import com.ymm.app.android.authorization.DriverLogin;
import com.ymm.app.android.performance.MainActivityAndrod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * Created by gujie on 2016/10/25.
 */
public class PerformanceTest extends AutoDataDriverBase {

    private AndroidDriver<AndroidElement> driver;
    private MainActivityAndrod mainActivityAndrod;
    private String nowCargo = "com.xiwei.logistics:id/layout_tab_1";
    private String dayCargo = "com.xiwei.logistics:id/layout_tab_2";
    private String service = "com.xiwei.logistics:id/layout_tab_3";
    private String person = "com.xiwei.logistics:id/layout_tab_4";

    @BeforeTest
    public void setUp() throws Exception {

        //读取properties配置
        Properties properties = new Properties();
        InputStream in;
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            in = loader.getResourceAsStream("config.properties");
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //安装指定APK文件
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app");
        File app = new File(appDir, "DRIVER.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", properties.getProperty("deviceName", "test"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion", "test"));
        capabilities.setCapability("udid", properties.getProperty("udid", "test"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage", "test"));
       // capabilities.setCapability("appActivity", properties.getProperty("appActivity", "test"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("url", "test")), capabilities);


    }

    @Test(dataProvider = "CsvDataProvider")
    public void PerfTest(String telephoneNum, String code, int count) throws UnsupportedEncodingException {
        //登录司机版
        new DriverLogin(driver, telephoneNum, code);
        this.mainActivityAndrod = new MainActivityAndrod(this.driver);

        for (int i = 0; i <= count; i++) {

            if (driver.findElement(By.id(nowCargo)).isSelected()){
                mainActivityAndrod.switchPage(dayCargo);
                new PerformanceUtil(driver, "当天货源页面响应时间", "com.xiwei.logistics:id/btn_call");
            }
            if (driver.findElement(By.id(dayCargo)).isSelected()){
                mainActivityAndrod.switchPage(service);
                new PerformanceUtil(driver, "服务页面响应时间", "com.xiwei.logistics:id/iv_short_ads1");
            }
            if (driver.findElement(By.id(service)).isSelected()){
                mainActivityAndrod.switchPage(person);
                new PerformanceUtil(driver, "个人中心页面响应时间", "com.xiwei.logistics:id/iv_avatar");
            }
            if (driver.findElement(By.id(person)).isSelected()){
                mainActivityAndrod.switchPage(nowCargo);
                new PerformanceUtil(driver, "即时货源响应时间", "com.xiwei.logistics:id/btn_start_sub");
            }

        }

        //关闭APP
        closeApp();

        //验证APP已经关闭
        appWait(1000);
        Assert.assertNotEquals(driver.currentActivity().toString(), ".carrier.ui.CarrierMainActivity");
        Assert.assertNotEquals(driver.currentActivity().toString(), ".common.ui.WelcomeActivity");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    //关闭APP方法
    public void closeApp() {
        driver.pressKeyCode(4);
        List<AndroidElement> closed_button = driver.findElementsByClassName("android.widget.Button");
        closed_button.get(1).click();
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
}
