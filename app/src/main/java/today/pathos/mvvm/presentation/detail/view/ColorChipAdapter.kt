package today.pathos.mvvm.presentation.detail.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import today.pathos.mvvm.R
import today.pathos.mvvm.databinding.ItemColorChipBinding
import today.pathos.mvvm.presentation.detail.viewmodel.ColorChipData

class ColorChipAdapter : RecyclerView.Adapter<ColorChipViewHolder>() {
    var colorChipList: List<ColorChipData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorChipViewHolder {
        val bnd = DataBindingUtil.inflate<ItemColorChipBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_color_chip, parent, false
        )
        return ColorChipViewHolder(bnd)
    }

    override fun onBindViewHolder(holder: ColorChipViewHolder, position: Int) {
        holder.bind(colorChipList[position])
    }

    override fun getItemCount(): Int = colorChipList.size
}
