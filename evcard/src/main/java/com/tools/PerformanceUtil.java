package com.tools;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by gujie on 2016/10/25.
 */
public class PerformanceUtil {

    private static final Logger LOG = LogManager.getLogger(PerformanceUtil.class);
    private AndroidDriver<AndroidElement> driver;

    public PerformanceUtil(AndroidDriver driver, String description, final String id){

        long start = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(new ExpectedCondition<WebElement>(){
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id(id));
            }});
        long end = System.currentTimeMillis();
        LOG.info(description + ":" + (end - start)+ "(毫秒)");
        //System.out.print(description + ":" + (end - start)+ "毫秒");

    }
}
