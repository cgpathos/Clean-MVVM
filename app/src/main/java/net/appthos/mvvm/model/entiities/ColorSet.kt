package net.appthos.mvvm.model.entiities

data class ColorSet(
    val id: Long,
    val name: String?,
    val colorChips: List<ColorChip>?
)
