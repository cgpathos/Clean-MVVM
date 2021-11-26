package today.pathos.mvvm.data.local.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class ColorSetDaoTest {
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase
    private lateinit var colorSetDao: ColorSetDao

    @get:Rule
    val rule: RuleChain = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        colorSetDao = appDatabase.colorSetDao()

        colorSetDao.insertAll(testColorSets)
        appDatabase.colorChipDao().insertAll(testColorChips)
    }

    @After
    fun closeDB() {
        appDatabase.close()
    }

    @Test
    fun testColorSetWithColorChips() {
        val expectResult = arrayListOf(
            ColorSetWithColorChips(
                testColorSets[0],
                testColorChips.asSequence().filter { it.colorSetId == testColorSets[0].id }.toList()
            ),
            ColorSetWithColorChips(
                testColorSets[1],
                testColorChips.asSequence().filter { it.colorSetId == testColorSets[1].id }.toList()
            ),
        )
        colorSetDao.getColorSetWithColorChipsList()
            .test()
            .assertNoErrors()
            .assertValue(expectResult)
            .assertComplete()
            .dispose()
    }
}