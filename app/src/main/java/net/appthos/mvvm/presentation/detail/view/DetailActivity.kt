package net.appthos.mvvm.presentation.detail.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import net.appthos.mvvm.R
import net.appthos.mvvm.databinding.ActivityDetailBinding
import net.appthos.mvvm.presentation.detail.viewmodel.DetailViewModel
import net.appthos.mvvm.presentation.detail.viewmodel.DetailViewState

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var bnd: ActivityDetailBinding
    private lateinit var adapter: ColorChipAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.viewState.observe(this, { transitionViewState(it) })

        adapter = ColorChipAdapter()
        bnd.listColorChip.layoutManager = LinearLayoutManager(this)
        bnd.listColorChip.adapter = adapter

        if (null == savedInstanceState) {
            viewModel.fetchColorSet(intent.getLongExtra("id", -1))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun transitionViewState(state: DetailViewState) {
        when (state) {
            is DetailViewState.Loading -> bnd.txtLoading.visibility = View.VISIBLE
            is DetailViewState.Success -> {
                bnd.txtLoading.visibility = View.GONE
                bnd.txtError.visibility = View.GONE
                bnd.listColorChip.visibility = View.VISIBLE

                supportActionBar?.title = state.colorSet.name
                adapter.colorChipList = state.colorSet.colorChips
            }
            is DetailViewState.Error -> {
                bnd.txtLoading.visibility = View.GONE
                bnd.listColorChip.visibility = View.GONE
                bnd.txtError.visibility = View.VISIBLE
                bnd.txtError.text = state.msg
            }
        }
    }

}