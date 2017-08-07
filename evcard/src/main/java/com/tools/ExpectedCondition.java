package com.tools;

import com.google.common.base.Function;
import io.appium.java_client.android.AndroidDriver;

/**
 * Create on 2017/8/7 9:03
 *
 * @author Cheney Wong
 */
public interface ExpectedCondition<T> extends Function<AndroidDriver, T> {
}
