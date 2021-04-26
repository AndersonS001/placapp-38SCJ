package com.ghostapps.placapp.domain.useCases.local

import com.ghostapps.placapp.domain.models.RecordModel

interface DeleteRegister {
    suspend fun execute(recordModel: RecordModel)
}