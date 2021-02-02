package net.appthos.mvvm.data.local.db

import androidx.room.*

@Entity(
    tableName = "COLOR_CHIP",
    foreignKeys = [
        ForeignKey(entity = ColorSetTable::class, parentColumns = ["id"], childColumns = ["color_set_id"])
    ],
    indices = [Index("color_set_id")]
)
data class ColorChipTable(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "color_set_id") val colorSetId: Long,
    val name: String?,
    @ColumnInfo(name = "color_hex") val color: String?
)
