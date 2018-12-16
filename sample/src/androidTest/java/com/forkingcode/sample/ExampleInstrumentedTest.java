package com.forkingcode.sample;

import androidx.test.annotation.UiThreadTest;

import com.forkingcode.androidjunitparams.AndroidJUnitParamsRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.Parameters;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Sample test to show using parameterized tests with the UiThreadTest rule.
 */
@RunWith(AndroidJUnitParamsRunner.class)
public class ExampleInstrumentedTest {
    @Test
    @Parameters(method = "evens")
    @UiThreadTest
    public void testEvens(int value) {
        int byThree = value * 3;

        assertThat(byThree % 2, is(0));
    }

    @Test
    @Parameters(method = "odds")
    public void testOdds(int value) {
        int byThree = value * 3;

        assertThat(byThree % 2, is(1));
    }

    @SuppressWarnings("unused")
    private Object[] evens() {
        // States that should result in no persistence
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
        // States that should result in no persistence
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
