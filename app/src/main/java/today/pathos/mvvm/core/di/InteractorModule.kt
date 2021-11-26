package today.pathos.mvvm.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import today.pathos.mvvm.data.local.db.DBColorChipRepository

import today.pathos.mvvm.domain.interactors.ColorChipInteractor

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {

    @Provides
    fun provideColorChipInteractor(repository: DBColorChipRepository) = ColorChipInteractor(repository)
}