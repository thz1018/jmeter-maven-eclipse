package testcase;

import com.ymm.app.android.activity.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Create on 2017/8/7 11:07
 *
 * @author Cheney Wong
 */
public class BusinessTest {
    private AndroidDriver<AndroidElement> androidDriver;
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
        androidDriver = GeneralTestOperation.testSetUp();
//        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public void loginTest() {
        splashActivity = new EvcardSplashActivity(this.androidDriver);
        mainActivityAndroid = new EvcardMainActivityAndroid(this.androidDriver);
        loginActivityAndroid = new EvcardLoginActivityAndroid(this.androidDriver);
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
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(this.androidDriver);
        splashActivity.clickSkipBtn();
        /* close activity page when it appears */
        mainActivityAndroid = new EvcardMainActivityAndroid(this.androidDriver);
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
        /* open modify phone */
        userInfosActivityAndroid = new EvcardUserInfosActivityAndroid(this.androidDriver);
        userInfosActivityAndroid.clickModifyPhone();
        /* back to user information */
        modifyPhoneActivityAndroid = new EvcardModifyPhoneActivityAndroid((this.androidDriver));
        modifyPhoneActivityAndroid.clickBack();
        /* open identification */
        userInfosActivityAndroid.clickIdentification();
        /* back to user information */
        userInfoUploadActivityAndroid = new EvcardUserInfoUploadActivityAndroid((this.androidDriver));
        userInfoUploadActivityAndroid.clickBack();
        /* open application process query */
        userInfosActivityAndroid.clickProgressQuery();
        /* back to user information */
        processManagerActivityAndroid = new EvcardProcessManagerActivityAndroid(this.androidDriver);
        processManagerActivityAndroid.clickBack();
        /* back to main menu */
        userInfosActivityAndroid.clickBack();

        /*
         * order management
         */

        /* open order management */
        mainActivityAndroid.clickOrder();
        /* open undo, done and all orders */
        myRecordActivityAndroid = new EvcardMyRecordActivityAndroid(this.androidDriver);
        myRecordActivityAndroid.clickUndo();
        myRecordActivityAndroid.clickDone();
        myRecordActivityAndroid.clickAll();
        /* open making invoice */
        myRecordActivityAndroid.clickInvoice();
        makeInvoiceActivityAndroid = new EvcardMakeInvoiceActivityAndroid(this.androidDriver);
        /* check ebi order and uncheck borrowing order */
        makeInvoiceActivityAndroid.clickCheckboxEbi();
        makeInvoiceActivityAndroid.clickCheckboxOrder();
        /* check all */
        makeInvoiceActivityAndroid.clickCheckboxCheckAll();
        /* open invoice illustration */
        makeInvoiceActivityAndroid.clickIllustration();
        /* back to making invoice */
        helpRegisterActivityAndroid = new EvcardHelpRegisterActivityAndroid(this.androidDriver);
        helpRegisterActivityAndroid.clickBack();
        /* open invoice history */
        makeInvoiceActivityAndroid.clickInvoiceHistory();
        /* open processing and done invoice */
        invoiceHistoryActivityAndroid = new EvcardInvoiceHistoryActivityAndroid(this.androidDriver);
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
        walletActivityAndroid = new EvcardWalletActivityAndroid(this.androidDriver);
        walletActivityAndroid.clickBalance();
        /* open expired ebi record */
        emountActivityAndroid = new EvcardQueryEmountActivityAndroid(this.androidDriver);
        emountActivityAndroid.clickEbiExpired();
        /* back to charging details */
        guoQiEmountActivityAndroid = new EvcardQueryGuoQiEmountActivityAndroid(this.androidDriver);
        guoQiEmountActivityAndroid.clickBack();
        /* back to wallet */
        emountActivityAndroid.clickBack();
        /* open recharging */
        walletActivityAndroid.clickEbiCharge();
        /* check AliPay, Wechat and Unibank */
        eChargeActivityAndroid = new EvcardEChargeActivityAndroid(this.androidDriver);
        eChargeActivityAndroid.clickWechat();
        eChargeActivityAndroid.clickUnibank();
        eChargeActivityAndroid.clickAlipay();
        /* back to wallet */
        eChargeActivityAndroid.clickBack();
        /* open deposit recharging */
        walletActivityAndroid.clickDeposit();
        /* open normal deposit recharging */
        cashPledgesItmsActivityAndroid = new EvcardCashPledgesItmsActivityAndroid(this.androidDriver);
        cashPledgesItmsActivityAndroid.clickNormalDeposit();
        /* back to deposit recharging */
        depositActivityAndroid = new EvcardDepositActivityAndroid(this.androidDriver);
        depositActivityAndroid.clickBack();
        ;
        /* open premium deposit recharging */
        cashPledgesItmsActivityAndroid.clickPremiumDeposit();
        /* back to premium deposit charging */
        highGradeDepositActivityAndroid = new EvcardHighGradeDepositActivityAndroid(this.androidDriver);
        highGradeDepositActivityAndroid.clickBack();
        /* back to deposit recharging */
        cashPledgesItmsActivityAndroid.clickBack();
    }

    @Test
    public void leasingTest() {
        /* skip splash screen */
        splashActivity = new EvcardSplashActivity(this.androidDriver);
        splashActivity.clickSkipBtn();
        /* close activity page and welcome page if they appear */
        mainActivityAndroid = new EvcardMainActivityAndroid(this.androidDriver);
        mainActivityAndroid.closeActivityPage();
        mainActivityAndroid.closeWelcomePage();
        /* repeat searching until find available cars */
        mainActivityAndroid.clickSearch();
        AndroidElement textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
        String string = textView.getText();
        while (string.equals(" X 0")) {
            androidDriver.pressKeyCode(4);
            mainActivityAndroid.swipeToRight();
            mainActivityAndroid.clickSearch();
            textView = androidDriver.findElement(By.id("com.baosight.carsharing:id/new_allow_car_count"));
            string = textView.getText();
        }
        mainActivityAndroid.swipeFromBottom();
        List<AndroidElement> availableCars = mainActivityAndroid.getAvailableCarList();
        availableCars.get(0).click();
        mainActivityAndroid.clickLeasing();
        mainActivityAndroid.confirmServiceFee();
        mainActivityAndroid.clickOrderingSuccess();
        mainActivityAndroid.clickGetCarManually();
        mainActivityAndroid.clickConfirmGetCar();
        mainActivityAndroid.clickReturnCar();
        mainActivityAndroid.clickConfirmReturnCar();
        mainActivityAndroid.clickConfirmPayment();
        mainActivityAndroid.click5Star();
        mainActivityAndroid.checkGreat();
        mainActivityAndroid.fillComment("666");
        mainActivityAndroid.clickSubmitComment();
        mainActivityAndroid.clickPayment();
        mainActivityAndroid.clickConfirmPayment();
        mainActivityAndroid.clickFinish();
    }
}
