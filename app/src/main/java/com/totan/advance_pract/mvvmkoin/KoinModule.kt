package com.totan.advance_pract.mvvmkoin

import org.koin.dsl.module

import org.koin.android.viewmodel.dsl.viewModel
val KoinModule= module {
  //  single<koinmodelaladhan>
    single {koinmodelaladhan()  }
    viewModel {koinviewmodelaladhan(get())}
}