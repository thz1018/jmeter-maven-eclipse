package testcase;

import com.tools.AndroidDriverWait;
import com.tools.ExpectedCondition;
import com.ymm.app.android.activity.EvcardMainActivityAndroid;
import com.ymm.app.android.activity.EvcardSplashActivity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Create on 2017/8/7 11:07
 *
 * @author Cheney Wong
 */
public class BusinessTest {
    private AndroidDriver<AndroidElement> androidDriver;
    /* activities */
    private EvcardSplashActivity splashActivity;
    private EvcardMainActivityAndroid mainActivityAndroid;

    @BeforeTest
    public void setUp() throws Exception {
        androidDriver = GeneralTestOperation.testSetUp();
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void rentingTest() {
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(this.androidDriver);
        splashActivity.clickSkipBtn();
        /* close activity page and welcome page if they appear */
        mainActivityAndroid = new EvcardMainActivityAndroid(this.androidDriver);
        mainActivityAndroid.closeActivityPage();
        mainActivityAndroid.closeWelcomePage();
        /* repeat searching until find available cars */
            mainActivityAndroid.clickSearch();
            mainActivityAndroid.swipeFromBottom();
        String string;
        do {
            AndroidElement textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
            string = textView.getText();
        } while (string.equals(" X 0"));
    }
}
