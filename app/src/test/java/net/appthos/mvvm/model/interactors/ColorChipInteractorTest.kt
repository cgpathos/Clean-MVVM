package net.appthos.mvvm.model.interactors

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import net.appthos.mvvm.model.entiities.ColorSet
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

class ColorChipInteractorTest {

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
    fun `컬러칩 리스트가 비었을때`() {
        Mockito.`when`(repository.getColorSetList()).thenReturn(Single.just(emptyList()))

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
        Mockito.`when`(repository.getColorSetList()).thenReturn(Single.error(RuntimeException("500 - Unknown error")))

        val result = interactor.getColorSetList()
        val testObserver = TestObserver<List<ColorSet>>()
        result.subscribe(testObserver)
        testObserver.assertValueCount(0)
        testObserver.assertError { it.message.equals("500 - Unknown error") }
    }

}