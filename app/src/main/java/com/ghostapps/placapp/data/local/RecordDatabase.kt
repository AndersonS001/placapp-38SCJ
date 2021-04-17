package com.ghostapps.placapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ghostapps.placapp.data.RecordMatchEntity
import com.ghostapps.placapp.data.RecordSetsEntity

@Database(entities = [RecordMatchEntity::class, RecordSetsEntity::class], version = 3)
abstract class RecordDatabase: RoomDatabase() {
    abstract fun recordDao(): RecordDao
}