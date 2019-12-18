package com.example.crashlyticspoc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_action_button.setOnClickListener {
            myDangerAction()
        }

        null_action_button.setOnClickListener {
            dangerAction()
        }

    }

    private fun myDangerAction() {
        val a: String? = null

        Crashlytics.log("HELLO")

        if (a == null) {
            throw DontUsedMeException()
        }
    }

    private fun dangerAction() {
        val a: String? = null

        Crashlytics.log("HELLO")

        if (a == null) {
            throw NullPointerException()
        }
    }

    fun action() {
        try {
            val a: String? = null

            Crashlytics.log("HELLO")

            if (a == null) {
                throw DontUsedMeException()
            }
        } catch (nullPointer: NullPointerException) {
            Log.e("HELLO", "HI")
            Crashlytics.logException(nullPointer)
        } catch (e: DontUsedMeException) {
            Log.e("Em...", "OwO)p")
            Crashlytics.logException(e)

        }
    }

}
