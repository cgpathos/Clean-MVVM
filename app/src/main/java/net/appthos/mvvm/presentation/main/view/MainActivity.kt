package net.appthos.mvvm.presentation.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import net.appthos.mvvm.R
import net.appthos.mvvm.databinding.ActivityMainBinding
import net.appthos.mvvm.presentation.detail.view.DetailActivity
import net.appthos.mvvm.presentation.main.viewmodel.MainData
import net.appthos.mvvm.presentation.main.viewmodel.MainViewModel
import net.appthos.mvvm.presentation.main.viewmodel.MainViewState
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var bnd: ActivityMainBinding
    private lateinit var adapter: ColorSetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.viewState.observe(this, { transitionViewState(it) })

        adapter = ColorSetAdapter()
        bnd.listColorSet.layoutManager = LinearLayoutManager(this)
        bnd.listColorSet.adapter = adapter

        adapter.clickSubject
            .throttleFirst(300, TimeUnit.MILLISECONDS)
            .subscribe({ colorSet -> clickColorSetItem(colorSet) }, {})

        if (null == savedInstanceState) {
            viewModel.fetchColorSetList()
        }
    }

    private fun transitionViewState(state: MainViewState) {
        when (state) {
            is MainViewState.Loading -> bnd.txtLoading.visibility = View.VISIBLE
            is MainViewState.Success -> {
                bnd.txtLoading.visibility = View.GONE
                bnd.txtError.visibility = View.GONE
                bnd.listColorSet.visibility = View.VISIBLE
                adapter.colorSetList = state.colorSetList
            }
            is MainViewState.Error -> {
                bnd.txtLoading.visibility = View.GONE
                bnd.listColorSet.visibility = View.GONE
                bnd.txtError.visibility = View.VISIBLE
                bnd.txtError.text = state.msg
            }
        }
    }

    private fun clickColorSetItem(colorSet: MainData) {
        startActivity(
            Intent(this, DetailActivity::class.java)
                .putExtra("id", colorSet.id)
        )
    }
}
