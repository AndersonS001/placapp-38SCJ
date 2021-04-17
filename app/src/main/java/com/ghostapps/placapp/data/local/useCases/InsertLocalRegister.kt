package com.ghostapps.placapp.data.local.useCases

import com.ghostapps.placapp.data.MatchWithSets
import com.ghostapps.placapp.data.RecordMatchEntity
import com.ghostapps.placapp.data.RecordSetsEntity
import com.ghostapps.placapp.data.local.RecordDatabase
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.models.RecordSetModel
import com.ghostapps.placapp.domain.useCases.InsertRegister

class InsertLocalRegister(
    private val database: RecordDatabase
) : InsertRegister {

    override fun execute(recordModel: RecordModel): RecordModel {
        val insert = database.recordDao().insert(RecordMatchEntity.fromModel(recordModel))

        recordModel.id = insert

        return recordModel
    }

    override fun execute(recordSetModel: RecordSetModel) {
        database.recordDao().insert(RecordSetsEntity.fromModel(recordSetModel))
    }
}