package today.pathos.mvvm.presentation.main.viewmodel

import today.pathos.mvvm.core.extensions.safeColorHex
import today.pathos.mvvm.domain.Mapper
import today.pathos.mvvm.domain.entiities.ColorSet
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