package com.example.daggertutorial.di

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Suger(
    /** The name.  */
    val value: String = "suger"
)
