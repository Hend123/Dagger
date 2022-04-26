package com.example.daggertutorial.model

import android.util.Log
import javax.inject.Inject

class Farm {
    @Inject
    constructor() {
        Log.d(LOG_TAG, "Farm: ")

    }
    fun getBeans():String{
        return "Beans"
    }
    companion object{
        private const val LOG_TAG = "Test"
    }
}