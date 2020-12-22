package net.appthos.mvvm.model.repositories

import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.model.entiities.ColorSet
import net.appthos.mvvm.model.interactors.ColorChipRepository

class ApiColorChipRepository : ColorChipRepository {
    override fun getColorSetList(): Single<List<ColorSet>> {
        return Single.just(emptyList())
    }

    override fun getColorSet(id: Long): Single<ColorSet> {
        TODO("Not yet implemented")
    }
}