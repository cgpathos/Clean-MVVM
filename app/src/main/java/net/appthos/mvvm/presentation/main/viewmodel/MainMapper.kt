package net.appthos.mvvm.presentation.main.viewmodel

import net.appthos.mvvm.core.extensions.safeColorHex
import net.appthos.mvvm.domain.Mapper
import net.appthos.mvvm.domain.entiities.ColorSet
import javax.inject.Inject

class MainMapper @Inject constructor() : Mapper<ColorSet, MainData>() {
    override fun map(value: ColorSet): MainData {
        return MainData(
            value.id,
            value.name ?: "",
            value.colorChips?.component1()?.color?.safeColorHex() ?: "",
            value.colorChips?.component2()?.color?.safeColorHex() ?: "",
            value.colorChips?.component3()?.color?.safeColorHex() ?: "",
            value.colorChips?.component4()?.color?.safeColorHex() ?: "",
            value.colorChips?.component5()?.color?.safeColorHex() ?: "",
        )
    }

    override fun reverseMap(value: MainData): ColorSet {
        TODO("Not yet implemented")
    }
}