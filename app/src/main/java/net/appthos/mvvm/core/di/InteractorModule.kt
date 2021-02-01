package net.appthos.mvvm.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.appthos.mvvm.data.local.db.DBColorChipRepository

import net.appthos.mvvm.domain.interactors.ColorChipInteractor
import net.appthos.mvvm.data.remote.ApiColorChipRepository

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Provides
    fun provideColorChipInteractor(repository: DBColorChipRepository) = ColorChipInteractor(repository)
}