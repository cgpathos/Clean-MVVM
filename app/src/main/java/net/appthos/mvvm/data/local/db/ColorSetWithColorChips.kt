package net.appthos.mvvm.data.local.db

import androidx.room.*
import net.appthos.mvvm.domain.entiities.ColorChip

data class ColorSetWithColorChips(
    @Embedded val colorSet: ColorSetTable,
    @Relation(
        parentColumn = "id",
        entityColumn = "color_set_id"
    )
    val colorChipList: List<ColorChipTable>,
)
