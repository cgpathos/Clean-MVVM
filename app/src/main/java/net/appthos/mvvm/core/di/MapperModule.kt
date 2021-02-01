package net.appthos.mvvm.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.appthos.mvvm.data.local.db.ColorSetMapper
import net.appthos.mvvm.presentation.detail.viewmodel.DetailMapper
import net.appthos.mvvm.presentation.main.viewmodel.MainMapper
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MapperModule {

    @Singleton
    @Provides
    fun provideColorSetMapper() : ColorSetMapper {
        return ColorSetMapper()
    }

    @Singleton
    @Provides
    fun provideMainMapper() : MainMapper = MainMapper()

    @Singleton
    @Provides
    fun provideDetailMapper() : DetailMapper = DetailMapper()
}