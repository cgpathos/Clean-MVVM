package net.appthos.mvvm.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import net.appthos.mvvm.model.interactors.ColorChipInteractor
import net.appthos.mvvm.model.repositories.ApiColorChipRepository

@Module
@InstallIn(ApplicationComponent::class)
object InteractorModule {

    @Provides
    fun provideColorChipInteractor(repository: ApiColorChipRepository) = ColorChipInteractor(repository)
}