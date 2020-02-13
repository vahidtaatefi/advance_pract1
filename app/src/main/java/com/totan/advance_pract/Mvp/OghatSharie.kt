package com.totan.advance_pract.Mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.totan.advance_pract.R
import kotlinx.android.synthetic.main.activity_oghat_sharie.*

class OghatSharie : AppCompatActivity(),Contract.View {
    override fun getcity(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oghat_sharie)
        btngo.setOnClickListener()
        {
          val city=city.text

        }
    }
}
