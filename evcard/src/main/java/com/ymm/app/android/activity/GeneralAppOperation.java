package com.ymm.app.android.activity;

/**
 * Create on 2017/8/3 14:03
 *
 * @author Cheney Wong
 */
public class GeneralAppOperation {

    public static void appWait(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
