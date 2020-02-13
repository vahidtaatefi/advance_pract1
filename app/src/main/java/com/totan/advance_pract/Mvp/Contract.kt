package com.totan.advance_pract.Mvp
interface Contract {

    interface View {
        fun getcitycountry(): Pair<String, String>

    }

    interface Presenter : ParentPresenter {
        fun onbtngo()
     //   fun onVerificationResponse(isValid: Boolean)
    }


    interface ParentPresenter
    {

    }
}

