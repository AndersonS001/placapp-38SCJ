package com.ghostapps.placapp.main.di

import com.ghostapps.placapp.data.remote.useCases.DeleteRemoteRegister
import com.ghostapps.placapp.data.remote.useCases.GetAllRemoteRegister
import com.ghostapps.placapp.data.remote.useCases.InsertRemoteRegister
import org.koin.dsl.module

object DataModules {
    val modules = module {
//        single {
//            Room.databaseBuilder(
//                androidApplication(),
//                RecordDatabase::class.java,
//                RecordMatchEntity.TABLE_NAME
//            ).fallbackToDestructiveMigration().build()
//
//        }

        factory {
            InsertRemoteRegister(get())
        }

        factory {
            DeleteRemoteRegister(get())
        }

        factory {
            GetAllRemoteRegister(get())
        }

    }
}