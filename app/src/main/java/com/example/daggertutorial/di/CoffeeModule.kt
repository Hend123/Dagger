package com.example.daggertutorial.di

import android.util.Log
import com.example.daggertutorial.model.River
import dagger.Module
import dagger.Provides

@Module
class CoffeeModule  {
    @Provides
    fun provideRiver(): River {
        Log.d("Test", "provideRiver: ")
        return  River()
    }
}