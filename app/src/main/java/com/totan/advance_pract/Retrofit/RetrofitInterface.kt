package com.totan.advance_pract.Retrofit

import com.totan.advance_pract.Kotlin.AladhanResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("timingsByCity")
    fun getTimings(
            @Query("city") city: String,
            @Query("country") country: String,
            @Query("method") method: Int
    ) : Call<AladhanResponseModel>
}