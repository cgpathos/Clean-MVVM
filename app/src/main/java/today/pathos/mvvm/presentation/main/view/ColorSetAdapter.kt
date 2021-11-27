package today.pathos.mvvm.presentation.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject
import today.pathos.mvvm.R
import today.pathos.mvvm.databinding.ItemColorSetBinding
import today.pathos.mvvm.presentation.main.viewmodel.MainData

class ColorSetAdapter : RecyclerView.Adapter<ColorSetViewHolder>() {
    val clickSubject: Subject<MainData> = PublishSubject.create<MainData>().toSerialized()

    var colorSetList: List<MainData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorSetViewHolder {
        val bnd = DataBindingUtil.inflate<ItemColorSetBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_color_set, parent, false
        )
        return ColorSetViewHolder(bnd, clickSubject)
    }

    override fun onBindViewHolder(holder: ColorSetViewHolder, position: Int) {
        holder.bind(colorSetList[position])
    }

    override fun getItemCount(): Int = colorSetList.size
}
