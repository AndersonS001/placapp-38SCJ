package com.ghostapps.placapp.domain.useCases.remote

import com.ghostapps.placapp.domain.models.RecordModel

interface InsertRemoteRegisterUseCase {
    fun execute(recordModel: RecordModel)

}