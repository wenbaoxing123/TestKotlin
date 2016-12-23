package com.mtime.testkotlin

import android.app.Application

/**
 * Created by wenbaoxing on 16/12/23.
 */
class App : Application() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}