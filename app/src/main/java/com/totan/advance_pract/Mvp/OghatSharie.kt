package com.totan.advance_pract.Mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.totan.advance_pract.Kotlin.Timings
import com.totan.advance_pract.R
import kotlinx.android.synthetic.main.activity_oghat_sharie.*

class OghatSharie : AppCompatActivity(), Contract.View {
    override fun showPrayerTime(prayerTimings: Timings?) {
        txtFajr.text =  prayerTimings?.Fajr
        txtSunrise.text = prayerTimings?.Sunrise
        txtDhuhur.text = prayerTimings?.Dhuhr
        txtSunset.text =  prayerTimings?.Sunset
        txtMidnight.text = prayerTimings?.Midnight

     //   Log.d("applog", prayerTimings?.Maghrib)


    }

    override fun showError() {
      Toast.makeText(this,"error",Toast.LENGTH_LONG).show()


    }

    override fun getcitycountry(): Pair<String, String> {
        val City = city.text.toString()
        val country = "iran".toString()
        return City to country

    }

    private val presenter: OghatSharie_presenter = OghatSharie_presenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oghat_sharie)
        btngo.setOnClickListener()
        {
            presenter.onbtngo()


        }
    }
}
