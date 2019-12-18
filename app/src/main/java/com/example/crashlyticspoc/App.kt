package com.example.crashlyticspoc

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler(
            CrashlyticsHandler(
                this
                , Thread.getDefaultUncaughtExceptionHandler()
            )
        )

    }
}