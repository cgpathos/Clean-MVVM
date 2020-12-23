package net.appthos.mvvm.presentation.main.view

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import net.appthos.mvvm.databinding.ItemColorSetBinding
import net.appthos.mvvm.presentation.main.viewmodel.ColorSetData

class ColorSetViewHolder(private val bnd: ItemColorSetBinding) : RecyclerView.ViewHolder(bnd.root) {
    fun bind(data: ColorSetData) {
        bnd.txtColorSetName.text = data.name
        bnd.colorChip1.setBackgroundColor(data.colorChipColor1.toColorInt())
        bnd.colorChip2.setBackgroundColor(data.colorChipColor2.toColorInt())
        bnd.colorChip3.setBackgroundColor(data.colorChipColor3.toColorInt())
        bnd.colorChip4.setBackgroundColor(data.colorChipColor4.toColorInt())
        bnd.colorChip5.setBackgroundColor(data.colorChipColor5.toColorInt())
    }
}