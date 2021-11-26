package today.pathos.mvvm.presentation.main.view

import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.subjects.Subject
import today.pathos.mvvm.databinding.ItemColorSetBinding
import today.pathos.mvvm.presentation.main.viewmodel.MainData

class ColorSetViewHolder(private val bnd: ItemColorSetBinding, private val clickSubject: Subject<MainData>) :
        RecyclerView.ViewHolder(bnd.root) {
    fun bind(data: MainData) {
        itemView.rootView.setOnClickListener {
            clickSubject.onNext(data)
        }

        bnd.txtColorSetName.text = data.name
        bnd.colorChip1.setBackgroundColor(data.colorChipColor1.toColorInt())
        bnd.colorChip2.setBackgroundColor(data.colorChipColor2.toColorInt())
        bnd.colorChip3.setBackgroundColor(data.colorChipColor3.toColorInt())
        bnd.colorChip4.setBackgroundColor(data.colorChipColor4.toColorInt())
        bnd.colorChip5.setBackgroundColor(data.colorChipColor5.toColorInt())
    }
}