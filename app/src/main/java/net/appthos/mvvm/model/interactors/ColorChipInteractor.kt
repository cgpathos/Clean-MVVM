package net.appthos.mvvm.model.interactors

import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.model.entiities.ColorSet

class ColorChipInteractor(private val repository: ColorChipRepository) {
    fun getColorSetList(): Single<List<ColorSet>> = repository.getColorSetList()

    fun getColorSet(id: Long): Single<ColorSet> = repository.getColorSet(id)
}