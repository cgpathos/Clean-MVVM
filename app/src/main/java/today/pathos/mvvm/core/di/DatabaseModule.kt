package today.pathos.mvvm.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import today.pathos.mvvm.core.DATABASE_NAME
import today.pathos.mvvm.data.local.db.AppDatabase
import today.pathos.mvvm.data.local.db.ColorChipDao
import today.pathos.mvvm.data.local.db.ColorSetDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .createFromAsset("colorChip-db")
            .build()
    }

    @Provides
    fun provideColorSetDao(appDatabase: AppDatabase): ColorSetDao {
        return appDatabase.colorSetDao()
    }

    @Provides
    fun provideColorChipDao(appDatabase: AppDatabase): ColorChipDao = appDatabase.colorChipDao()
}