package net.appthos.mvvm.presentation.detail.viewmodel

import net.appthos.mvvm.core.extensions.safeColorHex
import net.appthos.mvvm.core.presentation.Mapper
import net.appthos.mvvm.domain.entiities.ColorSet

class DetailMapper : Mapper<ColorSet, DetailData>() {
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