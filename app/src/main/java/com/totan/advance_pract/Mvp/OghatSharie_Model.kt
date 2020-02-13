package com.totan.advance_pract.Mvp

import android.util.Log
import com.totan.advance_pract.Kotlin.AladhanResponseModel
import com.totan.advance_pract.Retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class OghatSharie_Model(private val presenter: Contract.Presenter) {
    fun getoghat(City: String, country: String) {
        val retrofit= Retrofit.Builder()
                .baseUrl("https://api.aladhan.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val timings = retrofit.create(RetrofitInterface::class.java)
        timings.getTimings(City, country, 8).enqueue(object : Callback<AladhanResponseModel> {
            override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                // Log.d("appEror", t.message)
                presenter.onRetrofitResponse(false, null)
            }

            override fun onResponse(call: Call<AladhanResponseModel>, response: Response<AladhanResponseModel>) {
                //  Log.d("applog", response.body()?.data?.timings?.Maghrib.toString())
                val res = response.body()?.data?.timings
                presenter.onRetrofitResponse(true,res)

            }

        }


        )


    }


}