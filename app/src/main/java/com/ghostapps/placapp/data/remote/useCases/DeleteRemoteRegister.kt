package com.ghostapps.placapp.data.remote.useCases

import com.ghostapps.placapp.data.remote.RecordMatchEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.local.DeleteRegister
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DeleteRemoteRegister(
    private val db: FirebaseFirestore
) : DeleteRegister {
    override suspend fun execute(recordModel: RecordModel) {
        db.collection(RecordMatchEntity.COLLECTION_NAME).document(recordModel.documentId)
            .delete()
            .await()
    }
}