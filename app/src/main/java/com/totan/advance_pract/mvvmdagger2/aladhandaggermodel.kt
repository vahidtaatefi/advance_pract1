package com.totan.advance_pract.mvvmdagger2

import com.totan.advance_pract.Kotlin.AladhanResponseModel
import com.totan.advance_pract.Retrofit.RetrofitInterface
import com.totan.advance_pract.Retrofit.retrofininterfacemvvm
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Inject

class aladhandaggermodel@Inject constructor() {
    private fun getPrayTimeData(): retrofininterfacemvvm {
        val retrofit= Retrofit.Builder()
                .baseUrl("https://api.aladhan.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(retrofininterfacemvvm::class.java)


    }
    fun getAdhanObservable(country: String, city: String):Observable<AladhanResponseModel>{

        return getPrayTimeData().getTimings(city,country,8)
    }

}