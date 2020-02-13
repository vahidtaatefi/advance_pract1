package com.totan.advance_pract.Mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.totan.advance_pract.R
import kotlinx.android.synthetic.main.activity_oghat_sharie.*

class OghatSharie : AppCompatActivity(), Contract.View {
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
