package today.pathos.mvvm.presentation.detail.viewmodel

import today.pathos.mvvm.core.extensions.safeColorHex
import today.pathos.mvvm.domain.Mapper
import today.pathos.mvvm.domain.entiities.ColorSet
import javax.inject.Inject

class DetailMapper @Inject constructor() : Mapper<ColorSet, DetailData>() {
    override fun map(value: ColorSet): DetailData {
        val colorChipList = ArrayList<ColorChipData>()

        value.colorChips?.forEach {
            colorChipList.add(ColorChipData(it.name ?: "", it.color?.safeColorHex() ?: ""))
        }

        return DetailData(
            value.id,
            value.name ?: "",
            colorChipList,
        )
    }

    override fun reverseMap(value: DetailData): ColorSet {
        TODO("Not yet implemented")
    }
}