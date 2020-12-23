package net.appthos.mvvm.presentation.main.viewmodel

import net.appthos.mvvm.core.extensions.safeColorHex
import net.appthos.mvvm.core.presentation.Mapper
import net.appthos.mvvm.model.entiities.ColorSet

class ColorSetMapper : Mapper<ColorSet, ColorSetData>() {
    override fun map(value: ColorSet): ColorSetData {
        return ColorSetData(
            value.id,
            value.name ?: "",
            value.colorChips?.component1()?.color?.safeColorHex() ?: "",
            value.colorChips?.component2()?.color?.safeColorHex() ?: "",
            value.colorChips?.component3()?.color?.safeColorHex() ?: "",
            value.colorChips?.component4()?.color?.safeColorHex() ?: "",
            value.colorChips?.component5()?.color?.safeColorHex() ?: "",
        )
    }

    override fun reverseMap(value: ColorSetData): ColorSet {
        TODO("Not yet implemented")
    }
}