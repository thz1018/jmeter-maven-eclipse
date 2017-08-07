package com.ymm.app.android.activity;

import com.tools.AndroidDriverWait;
import com.tools.ExpectedCondition;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Create on 2017/8/3 13:51
 *
 * @author Cheney Wong
 */
public class EvcardMainActivityAndroid {
    private AndroidDriver<AndroidElement> androidDriver;
    private AndroidElement imageView;
    private AndroidElement button;
    private AndroidElement layout;
    private AndroidElement textView;
    private List<AndroidElement> elements;
    private AndroidElement editText;
    private AndroidElement checkbox;

    public EvcardMainActivityAndroid(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    /* click menu */
    public void clickMenu() {
        GeneralAppOperation.appWait(1000);
        imageView = androidDriver.findElement(By.id("com.baosight.carsharing:id/menu_img"));
        imageView.click();
    }

    /* click user portrait */
    public void clickImgHead() {
        GeneralAppOperation.appWait(1000);
        imageView = androidDriver.findElement(By.id("com.baosight.carsharing:id/img_head"));
        imageView.click();
    }

    /* click order */
    public void clickOrder() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_order"));
        layout.click();
    }

    /* click wallet */
    public void clickWallet() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_wallet"));
        layout.click();
    }

    /* click message */
    public void clickMessage() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_message"));
        layout.click();
    }

    /* click help */
    public void clickHelp() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_help"));
        layout.click();
    }

    /* click activity center */
    public void clickActivityCenter() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/activity_center"));
        layout.click();
    }

    /* click settings */
    public void clickSettings() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ic_setting"));
        layout.click();
    }

    /* click back */
    public void clickBack() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/backImg_user"));
        layout.click();
    }

    /* close activity page when it appears */
    public void closeActivityPage() {
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 1);
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(AndroidDriver androidDriver) {
                    return androidDriver.findElement(By.id("com.baosight.carsharing:id/huodong_close"));
                }
            });
            GeneralAppOperation.appWait(1000);
            element.click();
        } catch (Exception e) {
            System.out.println(">>> activity page didn't appear");
        }
    }

    /* close welcome page when it appears */
    public void closeWelcomePage() {
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 1);
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(AndroidDriver androidDriver) {
                    return androidDriver.findElement(By.id("com.baosight.carsharing:id/clear_btn"));
                }
            });
            GeneralAppOperation.appWait(5000);
            element.click();
        } catch (Exception e) {
            System.out.println(">>> welcome page didn't appear");
        }
    }

    /* click search station */
    public void clickSearch() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/center_or_city"));
        textView.click();
    }

    /* swipe form fixed position to center */
    public void swipeFromBottom() {
        GeneralAppOperation.appWait(1000);
        int width = androidDriver.manage().window().getSize().width;
        int height = androidDriver.manage().window().getSize().height;
        androidDriver.swipe(width / 2, height * 3 / 4, width / 2, height / 2, 500);
    }

    /* swipe from center to right */
    public void swipeToRight() {
        GeneralAppOperation.appWait(1000);
        int width = androidDriver.manage().window().getSize().width;
        int height = androidDriver.manage().window().getSize().height;
        androidDriver.swipe(width / 2, height / 2, width * 3 / 4, height / 2, 500);
    }

    /* swipe from center to right */
    public void swipeToLeft() {
        GeneralAppOperation.appWait(1000);
        int width = androidDriver.manage().window().getSize().width;
        int height = androidDriver.manage().window().getSize().height;
        androidDriver.swipe(width / 2, height / 2, width / 4, height / 2, 500);
    }


    /* get available car list */
    public List<AndroidElement> getAvailableCarList() {
        GeneralAppOperation.appWait(500);
        elements = androidDriver.findElements(By.id("com.baosight.carsharing:id/carType_list"));
        return elements;
    }


    /* click leasing button */
    public void clickLeasing() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/text_detail_config"));
        button.click();
    }


    /* click the service fee tips */
    public void confirmServiceFee() {
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 1);
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(AndroidDriver androidDriver) {
                    return androidDriver.findElement(By.id("com.baosight.carsharing:id/btn_cancle_order_ok"));
                }
            });
            GeneralAppOperation.appWait(1000);
            element.click();
        } catch (Exception e) {
            System.out.println(">>> no service fee here");
        }
    }

    /* click ordering success */
    public void clickOrderingSuccess() {
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 120);
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(AndroidDriver androidDriver) {
                    return androidDriver.findElement(By.id("com.baosight.carsharing:id/appointment_success_text"));
                }
            });
            GeneralAppOperation.appWait(1000);
            element.click();
        } catch (Exception e) {
            System.out.println(">>> ordering failed");
        }
    }

    /* click get car manually */
    public void clickGetCarManually() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/auto_car"));
        textView.click();
    }

    /* click confirm get car */
    public void clickConfirmGetCar() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/btn_ok"));
        textView.click();
    }

    /* click return car */
    public void clickReturnCar() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_app_button_rental_car"));
        button.click();
    }

    /* click confirm return */
    public void clickConfirmReturnCar() {
        GeneralAppOperation.appWait(1000);
        layout = androidDriver.findElement(By.id("com.baosight.carsharing:id/ly_okbackcar"));
        layout.click();
    }

    /* click confirm payment */
    public void clickConfirmPayment() {
        GeneralAppOperation.appWait(3000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/btn_sure"));
        textView.click();
    }

    /* click 5 star */
    public void click5Star() {
        GeneralAppOperation.appWait(30000);
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 120);
            WebElement element = wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(AndroidDriver androidDriver) {
                    return androidDriver.findElement(By.id("com.baosight.carsharing:id/img_star5"));
                }
            });
            GeneralAppOperation.appWait(1000);
            element.click();
        } catch (Exception e) {
            System.out.println(">>> return fail");
        }
    }

    /* fill comment */
    public void fillComment(String comment) {
        GeneralAppOperation.appWait(1000);
        editText = androidDriver.findElement(By.id("com.baosight.carsharing:id/evaluate_edit"));
        editText.sendKeys(comment);
    }

    /* check "Great" */
    public void checkGreat() {
        GeneralAppOperation.appWait(1000);
        checkbox = androidDriver.findElement(By.id("com.baosight.carsharing:id/evaluate_checkbox1"));
        checkbox.click();
    }

    /* click submit comment */
    public void clickSubmitComment() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/evaluate_submit"));
        button.click();
    }

    /* click payment */
    public void clickPayment() {
        GeneralAppOperation.appWait(1000);
        textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_btn_pay"));
        textView.click();
    }


    /* click finish business */
    public void clickFinish() {
        GeneralAppOperation.appWait(1000);
        button = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_share_finish"));
        button.click();
    }
}
