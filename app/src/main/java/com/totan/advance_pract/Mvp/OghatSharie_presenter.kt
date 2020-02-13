package com.totan.advance_pract.Mvp

class OghatSharie_presenter(private val view: Contract.View) : Contract.Presenter {
    private val model = OghatSharie_Model(this)
    override fun onbtngo() {

        val (city, country) = view.getcitycountry()
        model.getoghat(city, country)

    }

}

