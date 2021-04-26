//package com.ghostapps.placapp.data.local.useCases
//
//import com.ghostapps.placapp.data.local.RecordMatchEntity
//import com.ghostapps.placapp.data.local.RecordSetsEntity
//import com.ghostapps.placapp.data.local.RecordDatabase
//import com.ghostapps.placapp.domain.models.RecordModel
//import com.ghostapps.placapp.domain.useCases.local.DeleteRegister
//
//class DeleteLocalRegister(
//    private val database: RecordDatabase
//) : DeleteRegister {
//    override fun execute(recordModel: RecordModel) {
//        database.recordDao().delete(
//            RecordMatchEntity.fromModel(recordModel),
//            RecordSetsEntity.listFromModel(recordModel)
//        )
//    }
//}