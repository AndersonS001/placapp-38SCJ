package com.ghostapps.placapp.data.remote

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.models.RecordSetModel

class RecordSetsEntity(

    val gameSetNumber: Int = 0,

    val homeTeamPoints: Int = 0,

    val awayTeamPoints: Int = 0
) {
    companion object {

        fun listToModel(matchEntity: RecordMatchEntity): List<RecordSetModel> {
            val list: MutableList<RecordSetModel> = mutableListOf()

            matchEntity.gameSetList!!.forEach{
                list.add(
                    RecordSetModel(
                        homeTeamPoints = it.homeTeamPoints,
                        awayTeamPoints = it.awayTeamPoints,
                        gameSetNumber = it.gameSetNumber
                    )
                )
            }

            return list
        }

        fun listFromModel(recordModel: RecordModel): List<RecordSetsEntity> {
            val list: MutableList<RecordSetsEntity> = mutableListOf()

            recordModel.gameSetHistory!!.forEach {
                list.add(
                    RecordSetsEntity(
                        homeTeamPoints = it.homeTeamPoints,
                        awayTeamPoints = it.awayTeamPoints,
                        gameSetNumber = it.gameSetNumber
                    )
                )
            }

            return list
        }
    }
}