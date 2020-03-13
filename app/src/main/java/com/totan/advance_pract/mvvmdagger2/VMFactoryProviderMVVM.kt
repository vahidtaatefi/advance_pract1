package com.totan.advance_pract.mvvmdagger2
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class VMFactoryProviderMVVM @Inject constructor(val model: aladhandaggermodel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(aladhandaggerviewmodel::class.java) ->
                return aladhandaggerviewmodel(model) as T

            else -> throw IllegalArgumentException("ViewModel Is not provided")
        }

    }
}