package com.totan.advance_pract.Retrofit

import com.totan.advance_pract.Kotlin.AladhanResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofininterfacemvvm {
        @GET("timingsByCity")
        fun getTimings(
                @Query("city") city: String,
                @Query("country") country: String,
                @Query("method") method: Int
        ) : Observable<AladhanResponseModel>

}