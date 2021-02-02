package net.appthos.mvvm.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import io.reactivex.rxjava3.core.Completable

@Dao
interface ColorChipDao {
    @Insert
    fun insertAll(colorChips: List<ColorChipTable>)
}