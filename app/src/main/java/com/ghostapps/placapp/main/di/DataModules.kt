package com.ghostapps.placapp.main.di

import org.koin.dsl.module
import androidx.room.Room
import com.ghostapps.placapp.data.local.RecordDatabase
import com.ghostapps.placapp.data.RecordMatchEntity
import com.ghostapps.placapp.data.local.useCases.DeleteLocalRegister
import com.ghostapps.placapp.data.local.useCases.GetAllLocalRegister
import com.ghostapps.placapp.data.local.useCases.InsertLocalRegister
import org.koin.android.ext.koin.androidApplication

object DataModules {
    val modules = module {
        single {
            Room.databaseBuilder(
                androidApplication(),
                RecordDatabase::class.java,
                RecordMatchEntity.TABLE_NAME
            ).fallbackToDestructiveMigration().build()

        }

        factory {
            InsertLocalRegister(get())
        }

        factory {
            DeleteLocalRegister(get())
        }

        factory {
            GetAllLocalRegister(get())
        }

    }
}