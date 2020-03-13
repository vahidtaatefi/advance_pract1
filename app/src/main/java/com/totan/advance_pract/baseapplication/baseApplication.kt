package com.totan.advance_pract.baseapplication

import android.app.Application
import com.totan.advance_pract.mvvmkoin.KoinModule
import com.totan.advance_pract.mvvmkoin.koinmodelaladhan
import com.totan.advance_pract.mvvmkoin.koinviewmodelaladhan
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class baseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@baseApplication)
            modules(KoinModule)

          //  modules(koinmodelaladhan, koinviewmodelaladhan, KoinModule)
            //  modules(koinviewmodelaladhan,KoinModule)
        }
    }
}
