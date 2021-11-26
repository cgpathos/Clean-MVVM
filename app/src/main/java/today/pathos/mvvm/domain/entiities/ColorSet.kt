package today.pathos.mvvm.domain.entiities

data class ColorSet(
    val id: Long,
    val name: String?,
    val colorChips: List<ColorChip>?
)
