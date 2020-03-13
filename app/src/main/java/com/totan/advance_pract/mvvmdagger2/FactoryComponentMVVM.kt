package com.totan.advance_pract.mvvmdagger2

import dagger.Component

@Component
interface FactoryComponentMVVM {
    fun provideVMFactory():VMFactoryProviderMVVM

}