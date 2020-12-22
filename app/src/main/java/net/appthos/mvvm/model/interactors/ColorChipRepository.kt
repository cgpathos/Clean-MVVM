package net.appthos.mvvm.model.interactors

import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.model.entiities.ColorSet

interface ColorChipRepository {
    fun getColorSetList(): Single<List<ColorSet>>
    fun getColorSet(id: Long): Single<ColorSet>
}