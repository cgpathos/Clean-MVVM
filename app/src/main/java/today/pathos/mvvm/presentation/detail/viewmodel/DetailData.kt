package today.pathos.mvvm.presentation.detail.viewmodel

data class DetailData(
    val id: Long,
    val name: String,
    val colorChips: List<ColorChipData> = emptyList(),
)

data class ColorChipData(
    val name: String,
    val color: String,
)