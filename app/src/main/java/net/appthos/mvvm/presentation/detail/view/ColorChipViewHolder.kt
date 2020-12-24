package net.appthos.mvvm.presentation.detail.view

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import net.appthos.mvvm.databinding.ItemColorChipBinding
import net.appthos.mvvm.presentation.detail.viewmodel.ColorChipData

class ColorChipViewHolder(private val bnd: ItemColorChipBinding) :
        RecyclerView.ViewHolder(bnd.root) {
    fun bind(data: ColorChipData) {
        bnd.txtColorChipName.text = data.name
        bnd.txtColorChipColor.text = data.color
        bnd.colorChip.setBackgroundColor(data.color.toColorInt())
    }
}