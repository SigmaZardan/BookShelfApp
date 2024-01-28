package com.example.bookshelfapp

import android.app.Application
import com.example.bookshelfapp.data.AppContainer
import com.example.bookshelfapp.data.DefaultAppContainer

class BookShelfApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}