package com.forkingcode.sample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import android.os.Looper;

import androidx.test.annotation.UiThreadTest;

import com.forkingcode.androidjunitparams.AndroidJUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.Parameters;

/**
 * Sample test to show using parameterized tests with the UiThreadTest rule.
 */
@RunWith(AndroidJUnitParamsRunner.class)
public class ExampleInstrumentedTest {

    @SuppressWarnings("JUnitMalformedDeclaration")  // Test doesn't want parameters
    @Test
    @Parameters(method = "evens")
    @UiThreadTest
    public void testEvens(int value) {

        // Ensure running on UI thread per UiThreadTest annotation (library validation)
        assertThat(Looper.myLooper(), is(Looper.getMainLooper()));

        // Sample test checking value is even
        int byThree = value * 3;
        assertThat(byThree % 2, is(0));
    }

    @SuppressWarnings("JUnitMalformedDeclaration")  // Test doesn't want parameters
    @Test
    @Parameters(method = "odds")
    public void testOdds(int value) {

        // Ensure not running on UI thread without annotation (library validation)
        assertThat(Looper.myLooper(), is(nullValue()));

        // Sample test checking value is odd
        int byThree = value * 3;
        assertThat(byThree % 2, is(1));
    }

    @SuppressWarnings("unused")
    private Object[] evens() {
        return new Object[]{
                2,
                4,
                6,
                8,
                12,
                14
        };
    }

    @SuppressWarnings("unused")
    private Object[] odds() {
        return new Object[]{
                1,
                3,
                5,
                7,
                11,
                13
        };
    }

}
