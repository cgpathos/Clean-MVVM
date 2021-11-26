package today.pathos.mvvm.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COLOR_SET")
data class ColorSetTable(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo val name: String?,
)
