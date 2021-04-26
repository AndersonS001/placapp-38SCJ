//package com.ghostapps.placapp.data.local.useCases
//
//import com.ghostapps.placapp.data.local.RecordDatabase
//import com.ghostapps.placapp.domain.models.RecordModel
//import com.ghostapps.placapp.domain.useCases.local.GetAllRegister
//
//class GetAllLocalRegister(
//    private val database: RecordDatabase
//) : GetAllRegister {
//
//    override fun execute(): List<RecordModel> {
//        return database.recordDao().getRecords().map { recordEntity -> recordEntity.toModel() }
//    }
//
//}