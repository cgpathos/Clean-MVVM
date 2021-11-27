package today.pathos.mvvm.presentation.detail.view

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import today.pathos.mvvm.databinding.ItemColorChipBinding
import today.pathos.mvvm.presentation.detail.viewmodel.ColorChipData

class ColorChipViewHolder(private val bnd: ItemColorChipBinding) :
        RecyclerView.ViewHolder(bnd.root) {
    fun bind(data: ColorChipData) {
        bnd.txtColorChipName.text = data.name
        bnd.txtColorChipColor.text = data.color
        bnd.colorChip.setBackgroundColor(data.color.toColorInt())
    }
}