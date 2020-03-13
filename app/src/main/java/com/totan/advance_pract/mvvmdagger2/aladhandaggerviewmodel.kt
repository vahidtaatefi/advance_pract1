package com.totan.advance_pract.mvvmdagger2

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.totan.advance_pract.Kotlin.AladhanResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class aladhandaggerviewmodel(private val model: aladhandaggermodel):ViewModel() {
    private val disposable= CompositeDisposable()
    private val adhanResponse= MutableLiveData<AladhanResponseModel>()
    private val adhanError=MutableLiveData<String?>()
   // val model=com.totan.advance_pract.mvvm.model()
    fun getoghatdata(country:String,city:String) {
        //val (country, city)=view.getCountryCity()

        disposable.add(model.getAdhanObservable(country,city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adhanResponse.value=it
                    Log.d("myTest",it.data.timings.Fajr)

                },{
                    Log.d("myTest",it.message)
                    adhanError.value="Error in Retrieving aladhan data"
                }))


    }

    fun getResponse(): LiveData<AladhanResponseModel> = adhanResponse
    fun getError():LiveData<String?> = adhanError



    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}