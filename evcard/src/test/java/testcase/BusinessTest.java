package testcase;

import Listener.ScreenshotListener;
import com.tools.AndroidDriverWait;
import com.tools.AppiumServer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import com.ymm.app.android.activity.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import com.ymm.app.android.activity.EvcardMainActivityAndroid;
import com.ymm.app.android.activity.EvcardSplashActivity;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Create on 2017/8/7 11:07
 *
 * @author Cheney Wong
 */
@Listeners({ScreenshotListener.class})
public class BusinessTest {
    private AppiumServer appiumServer;
    private static AndroidDriver<AndroidElement> androidDriver;
    /* activity entities */
    private EvcardSplashActivity splashActivity;
    private EvcardMainActivityAndroid mainActivityAndroid;
    private EvcardUserInfosActivityAndroid userInfosActivityAndroid;
    private EvcardModifyPhoneActivityAndroid modifyPhoneActivityAndroid;
    private EvcardUserInfoUploadActivityAndroid userInfoUploadActivityAndroid;
    private EvcardProcessManagerActivityAndroid processManagerActivityAndroid;
    private EvcardMyRecordActivityAndroid myRecordActivityAndroid;
    private EvcardMakeInvoiceActivityAndroid makeInvoiceActivityAndroid;
    private EvcardHelpRegisterActivityAndroid helpRegisterActivityAndroid;
    private EvcardInvoiceHistoryActivityAndroid invoiceHistoryActivityAndroid;
    private EvcardWalletActivityAndroid walletActivityAndroid;
    private EvcardQueryEmountActivityAndroid emountActivityAndroid;
    private EvcardQueryGuoQiEmountActivityAndroid guoQiEmountActivityAndroid;
    private EvcardEChargeActivityAndroid eChargeActivityAndroid;
    private EvcardCashPledgesItmsActivityAndroid cashPledgesItmsActivityAndroid;
    private EvcardDepositActivityAndroid depositActivityAndroid;
    private EvcardHighGradeDepositActivityAndroid highGradeDepositActivityAndroid;
    private EvcardLoginActivityAndroid loginActivityAndroid;

    @BeforeTest
    public void setUp() throws Exception {


        appiumServer = new AppiumServer();
        appiumServer.runServer(4723, "LC75RZ901613");
        androidDriver = GeneralTestOperation.testSetUp();
//        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void loginTest() {
        splashActivity = new EvcardSplashActivity(androidDriver);
        mainActivityAndroid = new EvcardMainActivityAndroid(androidDriver);
        loginActivityAndroid = new EvcardLoginActivityAndroid(androidDriver);
        /* skip splash screen */
        splashActivity.clickSkipBtn();
        /* close activity page when it appears */
        mainActivityAndroid.closeActivityPage();
        /* close welcome page when it appears */
        mainActivityAndroid.closeWelcomePage();
        /* open menu */
        mainActivityAndroid.clickMenu();
        /* open login screen */
        mainActivityAndroid.clickImgHead();
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
        List<String> infos = new ArrayList<String>();
        infos.add(properties.getProperty("account", "test"));
        infos.add(properties.getProperty("password", "test"));
        /* fill the login info blanks and click login button */
        loginActivityAndroid.fillInfo(infos);
        loginActivityAndroid.clickLogin();
    }

    @Test
    public void MainMenuTraversalTest() {
        System.out.println(androidDriver.getPageSource());
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(androidDriver);
        splashActivity.clickSkipBtn();
        System.out.println(androidDriver.getPageSource());
        /* close activity page when it appears */
        mainActivityAndroid = new EvcardMainActivityAndroid(androidDriver);
        mainActivityAndroid.closeActivityPage();
        /* close welcome page when it appears */
        mainActivityAndroid.closeWelcomePage();
        /* open main menu */
        mainActivityAndroid.clickMenu();

        /*
         * user information
         */

        /* open user information */
        mainActivityAndroid.clickImgHead();
        System.out.println(androidDriver.getPageSource());
        /* open modify phone */
        userInfosActivityAndroid = new EvcardUserInfosActivityAndroid(androidDriver);
        userInfosActivityAndroid.clickModifyPhone();
        /* back to user information */
        modifyPhoneActivityAndroid = new EvcardModifyPhoneActivityAndroid(androidDriver);
        modifyPhoneActivityAndroid.clickBack();
        /* open identification */
        userInfosActivityAndroid.clickIdentification();
        /* back to user information */
        userInfoUploadActivityAndroid = new EvcardUserInfoUploadActivityAndroid(androidDriver);
        userInfoUploadActivityAndroid.clickBack();
        /* open application process query */
        userInfosActivityAndroid.clickProgressQuery();
        /* back to user information */
        processManagerActivityAndroid = new EvcardProcessManagerActivityAndroid(androidDriver);
        processManagerActivityAndroid.clickBack();
        /* back to main menu */
        userInfosActivityAndroid.clickBack();

        /*
         * order management
         */

        /* open order management */
        mainActivityAndroid.clickOrder();
        /* open undo, done and all orders */
        myRecordActivityAndroid = new EvcardMyRecordActivityAndroid(androidDriver);
        myRecordActivityAndroid.clickUndo();
        myRecordActivityAndroid.clickDone();
        myRecordActivityAndroid.clickAll();
        /* open making invoice */
        myRecordActivityAndroid.clickInvoice();
        makeInvoiceActivityAndroid = new EvcardMakeInvoiceActivityAndroid(androidDriver);
        /* check ebi order and uncheck borrowing order */
        makeInvoiceActivityAndroid.clickCheckboxEbi();
        makeInvoiceActivityAndroid.clickCheckboxOrder();
        /* check all */
        makeInvoiceActivityAndroid.clickCheckboxCheckAll();
        /* open invoice illustration */
        makeInvoiceActivityAndroid.clickIllustration();
        helpRegisterActivityAndroid.clickBack();
        /* open invoice history */
        makeInvoiceActivityAndroid.clickInvoiceHistory();
        /* open processing and done invoice */
        invoiceHistoryActivityAndroid = new EvcardInvoiceHistoryActivityAndroid(androidDriver);
        invoiceHistoryActivityAndroid.clickInvoiceprocessing();
        invoiceHistoryActivityAndroid.clickInvoiceDone();
        /* back to making invoice */
        invoiceHistoryActivityAndroid.clickBack();
        /* back to order management */
        makeInvoiceActivityAndroid.clickBack();
        /* back to main menu */
        myRecordActivityAndroid.clickBack();

        /*
         * wallet
         */

        /* open wallet */
        mainActivityAndroid.clickWallet();
        /* open charging details */
        walletActivityAndroid = new EvcardWalletActivityAndroid(androidDriver);
        walletActivityAndroid.clickBalance();
        /* open expired ebi record */
        emountActivityAndroid = new EvcardQueryEmountActivityAndroid(androidDriver);
        emountActivityAndroid.clickEbiExpired();
        /* back to charging details */
        guoQiEmountActivityAndroid = new EvcardQueryGuoQiEmountActivityAndroid(androidDriver);
        guoQiEmountActivityAndroid.clickBack();
        /* back to wallet */
        emountActivityAndroid.clickBack();
        /* open recharging */
        walletActivityAndroid.clickEbiCharge();
        /* check AliPay, Wechat and Unibank */
        eChargeActivityAndroid = new EvcardEChargeActivityAndroid(androidDriver);
        eChargeActivityAndroid.clickWechat();
        eChargeActivityAndroid.clickUnibank();
        eChargeActivityAndroid.clickAlipay();
        /* back to wallet */
        eChargeActivityAndroid.clickBack();
        /* open deposit recharging */
        walletActivityAndroid.clickDeposit();
        /* open normal deposit recharging */
        cashPledgesItmsActivityAndroid = new EvcardCashPledgesItmsActivityAndroid(androidDriver);
        cashPledgesItmsActivityAndroid.clickNormalDeposit();
        /* back to deposit recharging */
        depositActivityAndroid = new EvcardDepositActivityAndroid(androidDriver);
        depositActivityAndroid.clickBack();
        /* open premium deposit recharging */
        cashPledgesItmsActivityAndroid.clickPremiumDeposit();
        /* back to premium deposit charging */
        highGradeDepositActivityAndroid = new EvcardHighGradeDepositActivityAndroid(androidDriver);
        highGradeDepositActivityAndroid.clickBack();
        /* back to deposit recharging */
        cashPledgesItmsActivityAndroid.clickBack();
    }

    @Test
    public void leasingTest() {
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(androidDriver);
        splashActivity.clickSkipBtn();
        /* close activity page and welcome page if they appear */
        mainActivityAndroid = new EvcardMainActivityAndroid(androidDriver);
        mainActivityAndroid.closeActivityPage();
        mainActivityAndroid.closeWelcomePage();
        /* repeat searching until find available cars */
        mainActivityAndroid.clickSearch();
        AndroidElement textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
        String string = textView.getText();
        while (string.equals(" X  0")) {
            androidDriver.pressKeyCode(4);
            mainActivityAndroid.swipeToLeft();
            mainActivityAndroid.clickSearch();
            textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
            string = textView.getText();
        }
        /* swipe the panel */
        mainActivityAndroid.swipeFromBottom();
        /* choose the first available car */
        List<AndroidElement> availableCars = mainActivityAndroid.getAvailableCarList();
        availableCars.get(0).click();
        /* leasing */
        mainActivityAndroid.clickLeasing();
        /* confirm service fee if required */
        mainActivityAndroid.confirmServiceFee();
        /* ordering success */
        mainActivityAndroid.clickOrderingSuccess();
        /* get car manual */
        mainActivityAndroid.clickGetCarManually();
        /* confirm get car */
        mainActivityAndroid.clickConfirmGetCar();
        /* return car */
        mainActivityAndroid.clickReturnCar();
        /* confirm return car */
        mainActivityAndroid.clickConfirmReturnCar();
        /* confirm payment */
        mainActivityAndroid.clickConfirmPayment();
        /* choose 5 stars */
        mainActivityAndroid.click5Star();
        /* check first comment */
        mainActivityAndroid.checkGreat();
        /* input text comment */
        mainActivityAndroid.fillComment("666");
        /* confirm comment */
        mainActivityAndroid.clickSubmitComment();
        /* payment */
        mainActivityAndroid.clickPayment();
        /* confirm payment */
        mainActivityAndroid.clickConfirmPayment();
        /* finish leasing procedure */
        mainActivityAndroid.clickFinish();
    }

    @Test
    public void getToastTest() {
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(androidDriver);
        splashActivity.clickSkipBtn();
        /* close activity page and welcome page if they appear */
        mainActivityAndroid = new EvcardMainActivityAndroid(androidDriver);
        mainActivityAndroid.closeActivityPage();
        mainActivityAndroid.closeWelcomePage();
        mainActivityAndroid.clickMenu();
        mainActivityAndroid.clickWallet();
        walletActivityAndroid = new EvcardWalletActivityAndroid(androidDriver);
        walletActivityAndroid.clickEbiCharge();
        eChargeActivityAndroid = new EvcardEChargeActivityAndroid(androidDriver);
        eChargeActivityAndroid.clickRecharge();

        String message = "请输入充值金额";
        try {
            AndroidDriverWait wait = new AndroidDriverWait(androidDriver, 5);

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + message + "')]")));
            System.out.println(element.toString());
        } catch (Exception e) {
            System.out.println(">>> no toast");
        }
    }


    @AfterClass
    public void tearDown() {
        androidDriver.closeApp();
        appiumServer.stopserver();
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return androidDriver;
    }
}
