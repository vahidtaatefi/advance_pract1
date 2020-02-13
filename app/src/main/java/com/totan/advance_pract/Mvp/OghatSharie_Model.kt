package com.totan.advance_pract.Mvp

import android.util.Log
import com.totan.advance_pract.Kotlin.AladhanResponseModel
import com.totan.advance_pract.Retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class OghatSharie_Model(private val presenter: Contract.ParentPresenter) {
    fun getoghat(City:String){
        val retrofit=Retrofit.Builder()
                .baseUrl("http://api.aladhan.com/v1/")
                .build()
        val timings=retrofit.create(RetrofitInterface::class.java)
        timings.getTimings("tehran","iran",8).enqueue(object :Callback<AladhanResponseModel>{
            override fun onFailure(call: Call<AladhanResponseModel>, t: Throwable) {
                Log.d("appEror",t.message)
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<AladhanResponseModel>, response: Response<AladhanResponseModel>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }


        )


    }


}