package com.example.crashlyticspoc

import android.content.Context
import android.content.Intent
import kotlin.system.exitProcess


class CrashlyticsHandler(
    private val context: Context,
    private val defaultUncaughtExceptionHandler: Thread.UncaughtExceptionHandler
) : Thread.UncaughtExceptionHandler {


    override fun uncaughtException(t: Thread, e: Throwable) {
        if (e.cause?.cause is DontUsedMeException) {
            restartApp()
        } else {
            defaultUncaughtExceptionHandler.uncaughtException(t, e)
        }
    }

    private fun restartApp() {
        val intent = Intent(context, MainActivity::class.java).apply {
            this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
        exitProcess(0)
    }


}