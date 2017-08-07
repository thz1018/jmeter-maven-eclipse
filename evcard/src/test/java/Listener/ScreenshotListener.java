package Listener;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import testcase.BusinessTest;

public class ScreenshotListener extends TestListenerAdapter{
    @Override
    public void onTestFailure(ITestResult tr){
     //  BusinessTest businessTest=new BusinessTest();
        AndroidDriver<AndroidElement> driver = BusinessTest.getDriver();
        File location = new File("screenshots1");
        String screenShotName = location.getAbsolutePath()+File.separator+tr.getMethod().getMethodName()+".png";
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(screenShotName));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

}
