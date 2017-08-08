package testcase;

import com.tools.AppiumServer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Create on 2017/8/4 14:21
 *
 * @author Cheney Wong
 */
class GeneralTestOperation {
    static AndroidDriver<AndroidElement> testSetUp() throws MalformedURLException {
        /* read config from external file */
        Properties properties = new Properties();
        InputStream inputStream;
        // noinspection Duplicates
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            inputStream = classLoader.getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        /* get the certain apk file */
        File pathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(pathRoot, "app");
        File app = new File(appDir, properties.getProperty("apkFileName", "evcard.apk"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", properties.getProperty("deviceName", "test"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion", "test"));
//        capabilities.setCapability("udid", properties.getProperty("udid", "test"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage", "test"));
        capabilities.setCapability("app", app.getAbsolutePath());
        /* do not install every time */
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        /* convert input into unicode keyboard */
        capabilities.setCapability("unicodeKeyboard", "True");
        /* reset to default keyboard after operations */
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        //AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL(properties.getProperty("url", "test")), capabilities);
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+4723+"/wd/hub"), capabilities);
        return androidDriver;
    }
}
