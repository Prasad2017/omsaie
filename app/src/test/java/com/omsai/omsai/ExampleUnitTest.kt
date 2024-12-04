package com.omsai.omsai

import android.os.Environment
import org.junit.Test
import java.io.File

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        val folder =
            File(Environment.getExternalStorageDirectory().absolutePath + "/WhatsApp/Media/WhatsApp Images")
        if (folder.exists()) {
            print("ok")
        } else {
            print("sayonara")
        }
    }
}