package com.example.daggertutorial.model

import android.util.Log
import javax.inject.Inject

class River {
//for view only
    constructor() {
        Log.d(LOG_TAG, "River: ")

    }
    fun getWater():String{
       return "Water"
    }
    companion object{
        private const val LOG_TAG = "Test"
    }
}
