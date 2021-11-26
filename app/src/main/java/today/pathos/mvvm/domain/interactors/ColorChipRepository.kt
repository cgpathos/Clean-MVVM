package today.pathos.mvvm.domain.interactors

import io.reactivex.rxjava3.core.Single
import today.pathos.mvvm.domain.entiities.ColorSet

interface ColorChipRepository {
    fun getColorSetList(): Single<List<ColorSet>>
    fun getColorSet(id: Long): Single<ColorSet>
}