package com.ghostapps.placapp.viewModel.gameRecords

import androidx.lifecycle.MutableLiveData
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.local.DeleteRegister
import com.ghostapps.placapp.domain.useCases.local.GetAllRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRecordsViewModel(
    private val getAllRegister: GetAllRegister,
    private val deleteRegister: DeleteRegister
) : BaseViewModel() {
    val recordsList = MutableLiveData<MutableList<RecordModel>>()

    suspend fun loadRecords() =
        withContext(Dispatchers.Default) {
            recordsList.postValue(getAllRegister.execute())
        }

//        recordsList.postValue(getAllRegister.execute())


//        val lst = getAllRegister.execute()
//        Thread.sleep(350)
//        recordsList.postValue(lst)

//        recordsList.value = recordsList.value

    suspend fun deleteRegister(recordModel: RecordModel) {
//        Thread {
            deleteRegister.execute(recordModel)
            loadRecords()
//        }.start()
    }

}