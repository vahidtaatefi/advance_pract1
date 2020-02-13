package com.totan.advance_pract.Mvp

import com.totan.advance_pract.Kotlin.Timings

interface Contract {

    interface View {
        fun getcitycountry(): Pair<String, String>
        fun showPrayerTime(prayerTimings: Timings?)
        fun showError()

    }

    interface Presenter : ParentPresenter {
        fun onbtngo()
        fun onRetrofitResponse(isSucceed: Boolean, prayerTimings: Timings?)
     //   fun onVerificationResponse(isValid: Boolean)
    }


    interface ParentPresenter
    {

    }
}

