package today.pathos.mvvm.presentation.main.viewmodel.ability

import android.util.Log
import androidx.activity.result.ActivityResultRegistry
import today.pathos.mvvm.core.presentation.ability.ActivityNavigator

class ActivityNavigatorDelegator(
    override val activityResultRegistry: ActivityResultRegistry,
) : ActivityNavigator {
    companion object {
        const val TAG = "MainActivityNavigatorDelegator"
    }

    override fun launch() {
        Log.i(TAG, "launch: ")
    }
}