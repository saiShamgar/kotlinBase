package com.sai.kotlinbase.presentationLayer.viewModel

import androidx.lifecycle.ViewModel

class SampleViewModel(private val string:String):ViewModel() {

    fun testValues():String{
        return string;
    }
}