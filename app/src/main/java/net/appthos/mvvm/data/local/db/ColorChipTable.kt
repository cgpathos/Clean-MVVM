package net.appthos.mvvm.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COLOR_CHIP")
data class ColorChipTable(
    @PrimaryKey val uid: Long,
    val colorSetId: Long,
    val name: String?,
    @ColumnInfo(name = "color_hex") val color: String?
)
