package com.forkingcode.sample

import android.os.Looper
import androidx.test.annotation.UiThreadTest
import com.forkingcode.androidjunitparams.AndroidJUnitParamsRunner
import junitparams.Parameters
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Sample test to show using parameterized tests with the UiThreadTest rule.
 */
@Suppress("JUnitMalformedDeclaration")
@RunWith(AndroidJUnitParamsRunner::class)
class ExampleInstrumentedTest {
    // Test doesn't want parameters
    @Test
    @Parameters(method = "evens")
    @UiThreadTest
    fun testEvens(value: Int) {

        // Ensure running on UI thread per UiThreadTest annotation (library validation)
        assertThat(Looper.myLooper(), `is`(Looper.getMainLooper()))

        // Sample test checking value is even
        val byThree = value * 3
        assertThat(byThree % 2, `is`(0))
    }

    // Test doesn't want parameters
    @Test
    @Parameters(method = "odds")
    fun testOdds(value: Int) {

        // Ensure not running on UI thread without annotation (library validation)
        assertThat(Looper.myLooper(), `is`(nullValue()))

        // Sample test checking value is odd
        val byThree = value * 3
        assertThat(byThree % 2, `is`(1))
    }

    @Suppress("unused")
    private fun evens() = arrayOf(
        2,
        4,
        6,
        8,
        12,
        14
    )

    @Suppress("unused")
    private fun odds() = arrayOf(
        1,
        3,
        5,
        7,
        11,
        13
    )
}