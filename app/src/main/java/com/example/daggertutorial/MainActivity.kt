package com.example.daggertutorial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.daggertutorial.di.CoffeeComponent
import com.example.daggertutorial.di.DaggerCoffeeComponent
import com.example.daggertutorial.model.Coffee
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var coffee: Coffee
    companion object {
        private const val TAG = "Test"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val component:CoffeeComponent = DaggerCoffeeComponent.builder().suger(3).milk(5).build()
        component.inject(MainActivity@this)
        Log.d(TAG, coffee.getCoffeeCup())
    }
}