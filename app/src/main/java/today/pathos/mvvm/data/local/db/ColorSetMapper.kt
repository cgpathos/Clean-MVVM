package today.pathos.mvvm.data.local.db

import today.pathos.mvvm.domain.Mapper
import today.pathos.mvvm.domain.entiities.ColorChip
import today.pathos.mvvm.domain.entiities.ColorSet
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