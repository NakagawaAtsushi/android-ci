package com.example.uitest

import android.graphics.Bitmap
import androidx.test.runner.screenshot.Screenshot
import org.junit.rules.TestWatcher
import org.junit.runner.Description


class FailedTestWatcher : TestWatcher() {

    override fun failed(e: Throwable?, description: Description?) {
        super.failed(e, description)

        Screenshot.capture()
            .setName("test_failed")
            .setFormat(Bitmap.CompressFormat.PNG)
            .process()
    }
}