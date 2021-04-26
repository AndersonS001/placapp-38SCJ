package com.ghostapps.placapp.domain.useCases.local

import com.ghostapps.placapp.domain.models.RecordModel

interface GetAllRegister {
    suspend fun execute(): MutableList<RecordModel>
}

