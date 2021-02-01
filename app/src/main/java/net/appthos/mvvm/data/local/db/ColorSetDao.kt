package net.appthos.mvvm.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.rxjava3.core.Single

@Dao
interface ColorSetDao {
    @Transaction
    @Query("select * from COLOR_SET")
    fun getColorSetList(): Single<List<ColorSetWithColorChips>>

    @Transaction
    @Query("select * from COLOR_SET where id = :id")
    fun getColorSet(id: Long): Single<ColorSetWithColorChips>

    @Insert
    fun insertColorSet(colorSetTable: ColorSetTable)
}