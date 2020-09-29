package com.example.uitest

import android.Manifest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.Rule

import org.junit.Assert.*
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.GrantPermissionRule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val failedWatcher = FailedTestWatcher()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)

    @Test
    fun mainActivityTest() {

        // FirstFragmentで表示されるlabelがHello Espresso!になっていること
        onView(ViewMatchers.withId(R.id.label))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello Espresso!")))

        // edit_text に Hello を入力してキーボードを閉じる
        onView(ViewMatchers.withId(R.id.edit_text))
            .perform(ViewActions.typeText("Hello"), ViewActions.closeSoftKeyboard())

        // buttonをクリックする(SecondFragmentに遷移)
        onView(ViewMatchers.withId(R.id.button))
            .perform(ViewActions.click())

        // SecondFragmentのshow_textに入力した文字が表示されていること
        onView(ViewMatchers.withId(R.id.show_text))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello World")))
    }
}