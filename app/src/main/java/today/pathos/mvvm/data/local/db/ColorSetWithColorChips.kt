package today.pathos.mvvm.data.local.db

import androidx.room.*

data class ColorSetWithColorChips(
    @Embedded val colorSet: ColorSetTable,
    @Relation(
        parentColumn = "id",
        entityColumn = "color_set_id"
    )
    val colorChipList: List<ColorChipTable>,
)
