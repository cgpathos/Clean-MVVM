package today.pathos.mvvm.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import today.pathos.mvvm.data.local.db.ColorSetMapper
import today.pathos.mvvm.presentation.detail.viewmodel.DetailMapper
import today.pathos.mvvm.presentation.main.viewmodel.MainMapper
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