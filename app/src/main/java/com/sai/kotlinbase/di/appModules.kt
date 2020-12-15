package com.sai.kotlinbase.di

import com.sai.kotlinbase.domainLayer.api.Api
import com.sai.kotlinbase.domainLayer.api.RetrofitClient
import com.sai.kotlinbase.presentationLayer.viewModel.SampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModules= module{
    single(named("apiWithoutKey")) { provideApi() }
    single(named("apiWithKey")) { provideApiWithKey(get()) }
    single{ provideApiKey()}
    viewModel { SampleViewModel(get() as String) }
}

private fun provideApi()= RetrofitClient.getClient()!!.create(Api::class.java)
private fun provideApiWithKey(apiKey:String) = RetrofitClient.getClientWithApiKey(apiKey)!!.create(Api::class.java)
private fun provideApiKey()="1234"
