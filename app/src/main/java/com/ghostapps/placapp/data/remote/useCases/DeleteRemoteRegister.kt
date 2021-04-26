package com.ghostapps.placapp.data.remote.useCases

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.local.DeleteRegister
import com.google.firebase.firestore.FirebaseFirestore

class DeleteRemoteRegister(
    private val db: FirebaseFirestore
) : DeleteRegister {
    override fun execute(recordModel: RecordModel) {

    }
}