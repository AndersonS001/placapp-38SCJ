package com.ghostapps.placapp.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.placapp.domain.models.RecordModel
import kotlinx.android.synthetic.main.item_game_record.view.*

class RecordsListViewHolder(
    itemView: View,
    private val onDeletePressed: (recordModel: RecordModel) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(record: RecordModel) {
        itemView.itemGameRecordHomeTeamName.text = record.homeTeamName
        itemView.itemGameRecordHomeTeamScore.text = formatNumber(record.homeTeamSetScore)

        itemView.itemGameRecordAwayTeamName.text = record.awayTeamName
        itemView.itemGameRecordAwayTeamScore.text = formatNumber(record.awayTeamSetScore)

        for (i in 1..(record.gameSetHistory?.size ?: 0)) {

            val find = record.gameSetHistory?.find { it.gameSetNumber == i }

            when (i) {
                1 -> {
                    itemView.itemGameRecordHomeFirstSet.text =
                        formatNumber(find?.homeTeamPoints ?: 0)
                    itemView.itemGameRecordAwayFirstSet.text =
                        formatNumber(find?.awayTeamPoints ?: 0)
                }
                2 -> {
                    itemView.itemGameRecordHomeSecondSet.text =
                        formatNumber(find?.homeTeamPoints ?: 0)
                    itemView.itemGameRecordAwaySecondSet.text =
                        formatNumber(find?.awayTeamPoints ?: 0)
                }
                3 -> {
                    itemView.itemGameRecordHomeThirdSet.text =
                        formatNumber(find?.homeTeamPoints ?: 0)
                    itemView.itemGameRecordAwayThirdSet.text =
                        formatNumber(find?.awayTeamPoints ?: 0)
                }
                4 -> {
                    if (find != null) {
                        itemView.itemGameRecordDivisor4Set.text = "X"

                        itemView.itemGameRecordHomeFourthSet.text =
                            formatNumber(find.homeTeamPoints)

                        itemView.itemGameRecordAwayFourthSet.text =
                            formatNumber(find.awayTeamPoints)
                    }
                }
                5 -> {
                    if (find != null) {
                        itemView.itemGameRecordDivisor5Set.text = "X"

                        itemView.itemGameRecordHomeFifthSet.text = formatNumber(find.homeTeamPoints)

                        itemView.itemGameRecordAwayFifthSet.text = formatNumber(find.awayTeamPoints)
                    }
                }
            }
        }

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(record)
        }
    }

    private fun formatNumber(value: Int?): String {
        return String.format("%02d", value ?: 0)
    }
}