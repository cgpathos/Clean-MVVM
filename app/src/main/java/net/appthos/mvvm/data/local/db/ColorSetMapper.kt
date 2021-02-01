package net.appthos.mvvm.data.local.db

import net.appthos.mvvm.domain.Mapper
import net.appthos.mvvm.domain.entiities.ColorChip
import net.appthos.mvvm.domain.entiities.ColorSet
import javax.inject.Inject

class ColorSetMapper @Inject constructor() : Mapper<ColorSetWithColorChips, ColorSet>() {
    override fun map(value: ColorSetWithColorChips): ColorSet {
        val colorChipList = ArrayList<ColorChip>()

        value.colorChipList.forEach {
            colorChipList.add(ColorChip(it.name, it.color))
        }

        return ColorSet(value.colorSet.id, value.colorSet.name, colorChipList)
    }

    override fun reverseMap(value: ColorSet): ColorSetWithColorChips {
        TODO("Not yet implemented")
    }
}