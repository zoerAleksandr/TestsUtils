package com.geekbrains.tests.view.search

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.geekbrains.tests.R
import com.geekbrains.tests.TEST_NUMBER_OF_RESULTS_PLUS_1
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val toDetailsButton = onView(
            allOf(
                withId(R.id.toDetailsActivityButton), withText("to details"),
                isDisplayed()
            )
        )
        toDetailsButton.perform(click())

        val incrementButton = onView(
            allOf(
                withId(R.id.incrementButton), withText("+"),
                isDisplayed()
            )
        )
        incrementButton.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.totalCountTextView), withText(TEST_NUMBER_OF_RESULTS_PLUS_1),
                isDisplayed()
            )
        )
        textView.check(matches(withText(TEST_NUMBER_OF_RESULTS_PLUS_1)))

        incrementButton.check(matches(isDisplayed()))
    }
}
