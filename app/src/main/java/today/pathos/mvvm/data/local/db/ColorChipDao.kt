package today.pathos.mvvm.data.local.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ColorChipDao {
    @Insert
    fun insertAll(colorChips: List<ColorChipTable>)
}