package com.ghostapps.placapp.data.remote.useCases

import androidx.lifecycle.MutableLiveData
import com.ghostapps.placapp.data.remote.RecordMatchEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.local.GetAllRegister
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await


class GetAllRemoteRegister(
    private val db: FirebaseFirestore
) : GetAllRegister {

    override suspend fun execute(): MutableList<RecordModel> {
        val list: MutableList<RecordModel> = mutableListOf()

        val source = Source.CACHE

        val doc = db.collection(RecordMatchEntity.COLLECTION_NAME)
            .get(source)
            .await()


        for(document in doc.documents){
            val toObject = document.toObject<RecordMatchEntity>()

            list.add(RecordMatchEntity.toModel(toObject!!, document.id))
        }
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    val toObject = document.toObject<RecordMatchEntity>()
//
//                    list.add(RecordMatchEntity.toModel(toObject, document.id))
//                }
//            }
//            .addOnFailureListener {
//            }

        return list
    }

}