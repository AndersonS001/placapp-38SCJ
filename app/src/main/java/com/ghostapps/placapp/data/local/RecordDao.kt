//package com.ghostapps.placapp.data.local
//
//import androidx.room.*
//
//@Dao
//interface RecordDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(recordMatchEntity: RecordMatchEntity) : Long
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(recordSetsEntity: RecordSetsEntity)
//
//    @Delete
//    fun delete(recordMatchEntity: RecordMatchEntity, recordSetsEntity: List<RecordSetsEntity>)
//
//    @Transaction
//    @Query("SELECT * FROM ${RecordMatchEntity.TABLE_NAME}")
//    fun getRecords(): List<MatchWithSets>
//}