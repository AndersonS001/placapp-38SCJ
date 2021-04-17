package com.ghostapps.placapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class RecordModel(

    val homeTeamName: String,
    val homeTeamSetScore: Int?,

    val awayTeamName: String,
    val awayTeamSetScore: Int?,

    val gameSetHistory : @RawValue List<RecordSetModel>? = null,

    var id: Long
): Parcelable