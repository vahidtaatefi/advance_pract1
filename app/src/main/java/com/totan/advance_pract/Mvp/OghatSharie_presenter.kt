package com.totan.advance_pract.Mvp

import com.totan.advance_pract.Kotlin.Timings

class OghatSharie_presenter(private val view: Contract.View) : Contract.Presenter {
    override fun onRetrofitResponse(isSucceed: Boolean, prayerTimings: Timings?) {
        if(isSucceed)
            view.showPrayerTime(prayerTimings)
        else
            view.showError()
    }

    private val model = OghatSharie_Model(this)
    override fun onbtngo() {

        val (city, country) = view.getcitycountry()
        model.getoghat(city, country)

    }

}

