package com.ghostapps.placapp.data.remote.useCases

import com.ghostapps.placapp.data.remote.RecordMatchEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.remote.InsertRemoteRegisterUseCase
import com.google.firebase.firestore.FirebaseFirestore

class InsertRemoteRegister(
    private val db : FirebaseFirestore
) : InsertRemoteRegisterUseCase {

    override fun execute(recordModel: RecordModel) {

        val doc = db.collection(RecordMatchEntity.COLLECTION_NAME).document()

        doc.set(RecordMatchEntity.fromModel(recordModel))
    }
}