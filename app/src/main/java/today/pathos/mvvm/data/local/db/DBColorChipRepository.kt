package today.pathos.mvvm.data.local.db

import io.reactivex.rxjava3.core.Single
import today.pathos.mvvm.domain.entiities.ColorSet
import today.pathos.mvvm.domain.interactors.ColorChipRepository
import javax.inject.Inject

class DBColorChipRepository @Inject constructor(
    private val colorSetDao: ColorSetDao,
    private val colorSetMapper: ColorSetMapper
) : ColorChipRepository {
    override fun getColorSetList(): Single<List<ColorSet>> {
        return colorSetDao.getColorSetWithColorChipsList()
            .map { colorSetMapper.map(it) }
    }

    override fun getColorSet(id: Long): Single<ColorSet> {
        return colorSetDao.getColorSetById(id)
            .map { colorSetMapper.map(it) }
    }
}
