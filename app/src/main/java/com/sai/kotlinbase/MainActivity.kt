package com.sai.kotlinbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sai.kotlinbase.presentationLayer.viewModel.SampleViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<SampleViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(Companion.TAG, "onCreate: "+viewModel.testValues())
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}