package com.totan.advance_pract.mvvmkoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.totan.advance_pract.Kotlin.Timings
import com.totan.advance_pract.R
import com.totan.advance_pract.mvvm.viewmodel
import kotlinx.android.synthetic.main.activity_oghat_sharie.*
import org.koin.android.viewmodel.ext.android.viewModel

class koinactivityaladhan : AppCompatActivity() {
    val vm: koinviewmodelaladhan by viewModel()
    //   lateinit var vm: viewmodel
    lateinit var mainHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koinactivityaladhan)
        //     vm = ViewModelProvider(this).get(viewmodel::class.java)

        btngo.setOnClickListener() {

            vm.getoghatdata(getCountryCity().first, getCountryCity().second)
        }
        vm.getResponse().observe(this, androidx.lifecycle.Observer {
            showPrayerTime(it.data.timings)
        })

        vm.getError().observe(this, androidx.lifecycle.Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT)
        })

        mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(updateTextTask)


    }

    fun getCountryCity(): Pair<String, String> {
        val country = "iran".toString()
        val city = city.text.trim().toString()
        return country to city
    }

    fun showPrayerTime(prayerTimings: Timings?) {
        txtFajr.text = prayerTimings?.Fajr
        txtSunrise.text = prayerTimings?.Sunrise
        txtDhuhur.text = prayerTimings?.Dhuhr
        txtSunset.text = prayerTimings?.Sunset
        txtMidnight.text = prayerTimings?.Midnight
    }

    private val updateTextTask = object : Runnable {
        override fun run() {
            //   showUserTime()
            mainHandler.postDelayed(this, 1000)
        }
    }

    override fun onPause() {
        super.onPause()
        mainHandler.removeCallbacks(updateTextTask)

    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(updateTextTask)
    }
}
