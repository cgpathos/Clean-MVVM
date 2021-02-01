package net.appthos.mvvm.domain.interactors

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import net.appthos.mvvm.domain.entiities.ColorChip
import net.appthos.mvvm.domain.entiities.ColorSet
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class ColorChipInteractorTest {
    companion object {
        const val DUMMY_COLOR_SET_ID : Long = 9999
        const val DUMMY_COLOR_NAME = "COLOR_NAME"
    }

    @Rule
    @JvmField
    val rule = MockitoJUnit.rule()!!

    @Mock lateinit var repository: ColorChipRepository

    private lateinit var interactor: ColorChipInteractor

    @Before
    fun setUp() {
        interactor = ColorChipInteractor(repository)
    }

    @Test
    fun `ColorSet 리스트가 비었을때`() {
        Mockito
            .`when`(repository.getColorSetList())
            .thenReturn(Single.just(emptyList()))

        val result = interactor.getColorSetList()
        val testObserver = TestObserver<List<ColorSet>>()
        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        assertThat(testObserver.values()[0].size, `is`(0))
    }

    @Test
    fun `api호출 중 무언가 에러가 났을때`() {
        Mockito
            .`when`(repository.getColorSetList())
            .thenReturn(Single.error(RuntimeException("500 - Unknown error")))

        val result = interactor.getColorSetList()
        val testObserver = TestObserver<List<ColorSet>>()
        result.subscribe(testObserver)
        testObserver.assertValueCount(0)
        testObserver.assertError { it.message.equals("500 - Unknown error") }
    }

    @Test
    fun `ColorSet 상세 정보 조회`() {
        Mockito
            .`when`(repository.getColorSet(DUMMY_COLOR_SET_ID))
            .thenReturn(Single.just(ColorSet(
                DUMMY_COLOR_SET_ID,
                DUMMY_COLOR_NAME,
                listOf(
                    ColorChip("COLOR1", "#112233"),
                    ColorChip("COLOR2", "#144233"),
                    ColorChip("COLOR3", "#ffa233"),
                    ColorChip("COLOR4", "#baf233"),
                )
            )))

        val result = interactor.getColorSet(DUMMY_COLOR_SET_ID)
        val testObserver = TestObserver<ColorSet>()
        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val emittedResult = testObserver.values()[0]
        assertThat(emittedResult.id, `is`(DUMMY_COLOR_SET_ID))
        assertThat(emittedResult.name, `is`(DUMMY_COLOR_NAME))
        assertThat(emittedResult.colorChips?.size, `is`(4))
    }
}