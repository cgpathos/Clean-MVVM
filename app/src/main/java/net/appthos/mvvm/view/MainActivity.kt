package net.appthos.mvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import net.appthos.mvvm.R
import net.appthos.mvvm.core.extensions.toastIt
import net.appthos.mvvm.viewmodel.MainViewModel
import net.appthos.mvvm.viewmodel.MainViewState

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.viewState.observe(this,
                                    { state ->
                                        when (state) {
                                            is MainViewState.Loading -> toastIt("Loading")
                                            is MainViewState.Success -> toastIt("Success")
                                            is MainViewState.Error -> toastIt(state.msg)
                                        }
                                    })


        viewModel.fetchColorSetList()
    }
}