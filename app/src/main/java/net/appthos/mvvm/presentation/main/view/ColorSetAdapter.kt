package net.appthos.mvvm.presentation.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import net.appthos.mvvm.R
import net.appthos.mvvm.databinding.ItemColorSetBinding
import net.appthos.mvvm.presentation.main.viewmodel.ColorSetData

class ColorSetAdapter : RecyclerView.Adapter<ColorSetViewHolder>() {
    var colorSetList: List<ColorSetData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorSetViewHolder {
        val bnd = DataBindingUtil.inflate<ItemColorSetBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_color_set, parent, false
        )
        return ColorSetViewHolder(bnd)
    }

    override fun onBindViewHolder(holder: ColorSetViewHolder, position: Int) {
        holder.bind(colorSetList[position])
    }

    override fun getItemCount(): Int = colorSetList.size
}
