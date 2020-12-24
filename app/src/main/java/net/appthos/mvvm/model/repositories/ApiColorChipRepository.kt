package net.appthos.mvvm.model.repositories

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import net.appthos.mvvm.model.entiities.ColorChip
import net.appthos.mvvm.model.entiities.ColorSet
import net.appthos.mvvm.model.interactors.ColorChipRepository
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/**
 * dummy api
 */
class ApiColorChipRepository : ColorChipRepository {
    private val dummyItems = listOf(
        ColorSet(
            0, "Yellow", listOf(
                ColorChip("yellow", "FFF200"),
                ColorChip("mellow", "#F8DE7E"),
                ColorChip("cyber", "FFD300"),
                ColorChip("royal", "#FADA5E"),
                ColorChip("banana", "FCF4A3"),
                ColorChip("tuscany", "#FCD12A"),
                ColorChip("lemon", "#EFFD5F"),
                ColorChip("cream", "FFFDD0"),
                ColorChip("peach", "FFE5B4"),
                ColorChip("ecru", "CEB180"),
            )
        ),
        ColorSet(
            1, "Orange", listOf(
                ColorChip("orange", "#FC6600"),
                ColorChip("rust", "#8B4000"),
                ColorChip("tiger", "#FD6A02"),
                ColorChip("dark amber", "#883000"),
                ColorChip("honey", "#EB9605"),
                ColorChip("pumpkin", "#FF7417"),
                ColorChip("ochre", "#CC7722"),
            )
        ),
        ColorSet(
            2, "Blue", listOf(
                ColorChip("prussian", "#003152"),
                ColorChip("egyptian", "#1034A6"),
                ColorChip("olympic", "#008ECC"),
                ColorChip("teal", "#008081"),
                ColorChip("independence", "#4C516D"),
                ColorChip("steel", "#4682B4"),
                ColorChip("electric", "#7EF9FF"),
                ColorChip("sky", "#95C8D8"),
                ColorChip("carolina", "#57A0D3"),
                ColorChip("maya", "#73C2FB"),
                ColorChip("navy", "#000080"),
            )
        ),
        ColorSet(
            3, "Red", listOf(
                ColorChip("scarlet", "#FF2400"),
                ColorChip("salmon", "#FA8072"),
                ColorChip("carmine", "#960018"),
                ColorChip("desire", "#EA3C53"),
                ColorChip("persian", "#CA3433"),
                ColorChip("raspberry", "#D21F3C"),
                ColorChip("sangria", "#5E1914"),
                ColorChip("burgundy", "#8D021F"),
                ColorChip("imperial red", "#ED2939"),
            )
        ),
        ColorSet(
            4, "Purple", listOf(
                ColorChip("violet", "#EE82EE"),
                ColorChip("spicypink", "#FF1CAE"),
                ColorChip("violet flower", "#BF5FFF"),
                ColorChip("heart", "#6030A8"),
                ColorChip("plum", "#DDA0DD"),
                ColorChip("indigo", "#4B0082"),
                ColorChip("purple", "#800080"),
                ColorChip("fuchsia", "#FF00FF"),
            )
        ),
        ColorSet(
            5, "Green", listOf(
                ColorChip("forest", "#0B6623"),
                ColorChip("sage", "#9DC183"),
                ColorChip("olive", "#708238"),
                ColorChip("jungle", "#29AB87"),
                ColorChip("mint", "#98FB98"),
                ColorChip("tea", "#D0F0C0"),
                ColorChip("moss", "#8A9A5B"),
                ColorChip("laurel", "#A9BA9D"),
                ColorChip("neon", "#39FF14"),
                ColorChip("paris", "#50C878"),
            )
        ),
    )

    override fun getColorSetList(): Single<List<ColorSet>> {
        // 가끔 네트워크 에러나게 함
        return if (Random.nextInt(0, 10) == 0) {
            Single.error(RuntimeException("Unknown error!"))
        }
        else {
            Single.just(dummyItems)
                .delay(Random.nextLong(200, 3000), TimeUnit.MILLISECONDS)
        }
    }

    override fun getColorSet(id: Long): Single<ColorSet> {
        return Observable.fromIterable(dummyItems)
            .delay(Random.nextLong(200, 3000), TimeUnit.MILLISECONDS)
            .filter { it.id == id }
            .firstOrError()
    }
}