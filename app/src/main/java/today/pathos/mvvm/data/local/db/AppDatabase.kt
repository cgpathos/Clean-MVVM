package today.pathos.mvvm.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ColorSetTable::class, ColorChipTable::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun colorSetDao(): ColorSetDao
    abstract fun colorChipDao(): ColorChipDao
}