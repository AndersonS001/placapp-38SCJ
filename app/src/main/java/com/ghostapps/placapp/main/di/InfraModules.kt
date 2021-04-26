package com.ghostapps.placapp.main.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

object InfraModules {
    val modules = module {
        factory { Firebase.firestore }
    }
}