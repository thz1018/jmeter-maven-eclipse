//package testcase;
//
//import com.datadriver.AutoDataDriverBase;
//import com.tools.AndroidDriverWait;
//import com.tools.ExpectedCondition;
//import com.ymm.app.android.activity.EvcardLoginActivityAndroid;
//import com.ymm.app.android.activity.EvcardMainActivityAndroid;
//import com.ymm.app.android.activity.EvcardSplashActivity;
//import com.ymm.app.android.activity.GeneralAppOperation;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;
//
///**
// * Create on 2017/8/3 14:10
// *
// * @author Cheney Wong
// */
//public class LoginTestCheney {
//    private AndroidDriver<AndroidElement> androidDriver;
//    private EvcardMainActivityAndroid evcardMainActivityAndroid;
//    private EvcardSplashActivity evcardSplashActivity;
//    private EvcardLoginActivityAndroid evcardLoginActivityAndroid;
//
//    @BeforeTest
//    public void setUp() throws Exception {
//        androidDriver = GeneralTestOperation.testSetUp();
//        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void loginTest() {
//        this.evcardSplashActivity = new EvcardSplashActivity(this.androidDriver);
//        this.evcardMainActivityAndroid = new EvcardMainActivityAndroid(this.androidDriver);
//        this.evcardLoginActivityAndroid = new EvcardLoginActivityAndroid(this.androidDriver);
//        /* skip splash screen */
//        evcardSplashActivity.clickSkipBtn();
//        /* close activity page when it appears */
//        evcardMainActivityAndroid.closeActivityPage();
//        /* close welcome page when it appears */
//        evcardMainActivityAndroid.closeWelcomePage();
//        /* open menu */
//        evcardMainActivityAndroid.clickMenu();
//        /* open login screen */
//        evcardMainActivityAndroid.clickImgHead();
//        Properties properties = new Properties();
//        InputStream inputStream;
//        // noinspection Duplicates
//        try {
//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            inputStream = classLoader.getResourceAsStream("config.properties");
//            properties.load(inputStream);
//        } catch (FileNotFoundException fnf) {
//            fnf.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        List<String> infos = new ArrayList<String>();
//        infos.add(properties.getProperty("account", "test"));
//        infos.add(properties.getProperty("password", "test"));
//        /* fill the login info blanks and click login button */
//        evcardLoginActivityAndroid.fillInfo(infos);
//        evcardLoginActivityAndroid.clickLogin();
//    }
//}
