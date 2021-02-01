package net.appthos.mvvm.data.local.db

import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.domain.entiities.ColorSet
import net.appthos.mvvm.domain.interactors.ColorChipRepository
import javax.inject.Inject

class DBColorChipRepository @Inject constructor(
    private val colorSetDao: ColorSetDao,
    private val colorSetMapper: ColorSetMapper
) : ColorChipRepository {
    override fun getColorSetList(): Single<List<ColorSet>> {
        return colorSetDao.getColorSetList()
            .map { colorSetMapper.map(it) }
    }

    override fun getColorSet(id: Long): Single<ColorSet> {
        return colorSetDao.getColorSet(id)
            .map { colorSetMapper.map(it) }
    }
}
