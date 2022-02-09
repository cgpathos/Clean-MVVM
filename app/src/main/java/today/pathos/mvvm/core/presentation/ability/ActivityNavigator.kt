package today.pathos.mvvm.core.presentation.ability

import androidx.activity.result.ActivityResultRegistry

interface ActivityNavigator {
    val activityResultRegistry: ActivityResultRegistry

    fun launch()
}