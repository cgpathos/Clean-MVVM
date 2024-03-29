package today.pathos.mvvm.presentation.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import today.pathos.mvvm.domain.interactors.ColorChipInteractor
import today.pathos.mvvm.presentation.main.core.getValue
import org.junit.*
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
@Deprecated("JUnit test로 옮김 이건 그냥 샘플로 남겨두자")
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Inject lateinit var colorChipInteractor: ColorChipInteractor
    @Inject lateinit var mainMapper: MainMapper

    @Before
    fun setUp() {
        hiltRule.inject()

        viewModel = MainViewModel(colorChipInteractor, mainMapper)
    }

    @Test
    fun testFetchColorSetList() {
        viewModel.fetchColorSetList()
        Assert.assertNotNull(getValue(viewModel.viewState))
    }
}