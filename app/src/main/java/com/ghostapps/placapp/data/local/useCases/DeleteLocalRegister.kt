package com.ghostapps.placapp.data.local.useCases

import com.ghostapps.placapp.data.RecordMatchEntity
import com.ghostapps.placapp.data.RecordSetsEntity
import com.ghostapps.placapp.data.local.RecordDatabase
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister

class DeleteLocalRegister(
    private val database: RecordDatabase
) : DeleteRegister {
    override fun execute(recordModel: RecordModel) {
        database.recordDao().delete(
            RecordMatchEntity.fromModel(recordModel),
            RecordSetsEntity.listFromModel(recordModel)
        )
    }
}