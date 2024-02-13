package com.example.ddalkkak_android

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class DdalkkakApplication : Application(), Application.ActivityLifecycleCallbacks {

    init {
        instance = this
    }

    companion object {
        var instance: DdalkkakApplication? = null
        fun context(): Context {
            return instance!!.applicationContext
        }

        var isBackground = false
    }

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {

    }

    override fun onActivityStarted(p0: Activity) {
        isBackground = false
    }

    override fun onActivityResumed(p0: Activity) {
        isBackground = false
    }

    override fun onActivityPaused(p0: Activity) {
        isBackground = true
    }

    override fun onActivityStopped(p0: Activity) {

    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

    }

    override fun onActivityDestroyed(p0: Activity) {

    }

}