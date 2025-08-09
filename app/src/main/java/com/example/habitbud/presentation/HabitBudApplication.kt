package com.example.habitbud.presentation

import android.app.Application
import com.example.habitbud.di.appModules
import com.example.habitbud.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HabitBudApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@HabitBudApplication)
            modules(appModules, viewModelsModule)
        }
    }

}