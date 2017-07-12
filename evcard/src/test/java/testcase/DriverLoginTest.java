package testcase;

import com.datadriver.AutoDataDriverBase;
import com.tools.AppiumServer;
import com.ymm.app.android.activity.Evcard_Welcome_Activity_Android;
import com.ymm.app.android.activity.LoginVerifyActivityAndroid;
import com.ymm.app.android.authorization.DriverLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import javafx.scene.input.KeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by gujie on 2016/10/20.
 */
public class DriverLoginTest extends AutoDataDriverBase {

    private AndroidDriver<AndroidElement> driver;
    private Evcard_Welcome_Activity_Android evcard_Welcome_Activity_Android;
    private AndroidElement SiteTextView;
    private int pixel=100;

    @BeforeTest()
    //@Parameters({"port","udid"})
    public void setUp() throws Exception{

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

        //启动Appium server
        AppiumServer appiumServer=new AppiumServer();
        appiumServer.runServer(4723,"7N2MYN1528001420");
        appiumServer.runServer(4724,"ZX1G722D9V");

        //安装指定APK文件
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app");
        File app = new File(appDir, "evcard.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", properties.getProperty("deviceName", "test"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion", "test"));
        //capabilities.setCapability("udid",udid);
        capabilities.setCapability("udid",properties.getProperty("udid", "test"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage", "test"));
        //capabilities.setCapability("appActivity", properties.getProperty("appActivity", "test"));
        capabilities.setCapability("app", app.getAbsolutePath());
        //不需要每次安装
        //capabilities.setCapability("noReset", true);
        //driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"), capabilities);
        driver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("url", "test")), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    //,threadPoolSize=2
    @Test(dataProvider = "CsvDataProvider",priority = 1)
    public void LoginTest(String telephoneNum, String code) throws UnsupportedEncodingException {
        this.evcard_Welcome_Activity_Android=new Evcard_Welcome_Activity_Android(this.driver);
        //关闭欢迎页面按钮
        evcard_Welcome_Activity_Android.Clear();
        //关闭新手引导
        evcard_Welcome_Activity_Android.ClostNoviceboot();
        //点击菜单
        evcard_Welcome_Activity_Android.ClickMenu();
        //new DriverLogin(driver,telephoneNum,code);
        //点击登录
        evcard_Welcome_Activity_Android.ClickLogin();
        //输入账号密码
        evcard_Welcome_Activity_Android.InputLogin();
        //关闭APP
        closeApp();

        //验证APP已经关闭
     /*   appWait(1000);
        Assert.assertNotEquals(driver.currentActivity().toString(), ".carrier.ui.CarrierMainActivity");
        Assert.assertNotEquals(driver.currentActivity().toString(), ".common.ui.WelcomeActivity");*/
    }

    @Test(priority = 2)
    //站点信息校验
    public void CheckSiteInfo(){
        this.evcard_Welcome_Activity_Android=new Evcard_Welcome_Activity_Android(this.driver);
        //关闭欢迎页面按钮
        evcard_Welcome_Activity_Android.Clear();
        evcard_Welcome_Activity_Android.FindSite();
        SiteTextView = driver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
        //点击查找附近网点
        while (!SiteTextView.getText().equals(" X  0"))
        {
            driver.pressKeyCode(4);
            evcard_Welcome_Activity_Android.swipeToRight(driver,pixel+=50);
            evcard_Welcome_Activity_Android.FindSite();
            appWait(1000);
            SiteTextView = driver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
        }


    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    //关闭APP方法
    public void closeApp()
    {
        driver.pressKeyCode(4);
        //List<AndroidElement> closed_button = driver.findElementsByClassName("android.widget.Button");
        //closed_button.get(1).click();
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


