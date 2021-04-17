package com.ghostapps.placapp.domain.useCases

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.models.RecordSetModel

interface InsertRegister {
    fun execute(recordModel: RecordModel): RecordModel

    fun execute(recordSetModel: RecordSetModel)

}