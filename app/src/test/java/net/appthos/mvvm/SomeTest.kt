package net.appthos.mvvm

import org.junit.Test

class SomeTest {


    @Test
    fun testHash() {
        val target = 7
        val numbs = intArrayOf(1, 3, 2, 2, 5, 2, 4, 3)

        solution(target, numbs)
        solutionKotlinStyle(target, numbs)


    }

    /*
    나왔던 문제를 정리하자면

    target = 7
    numbs = [1, 3, 2, 2, 1, 2, 4, 3]

    배열에 연속된 값들의 합이 target인 조합중 제일 적은 갯수 조합의 size 구하기

    합이 target인 조합
    ----
    [3, 2, 2]
    [2, 2, 1, 2]
    [1, 2, 4]
    [4, 3]

    답은 2
    ([4,3]의 size)
     */
    private fun solution(target: Int, numbs: IntArray) {
        var length = numbs.size
        for (i in numbs.indices) {
            var counter = 0
            var sum = 0
            for (j in i until numbs.size) {
                if (sum > target) {
                    break
                } else if (sum == target && counter < length) {
                    length = counter
                    break
                }
                counter++
                sum += numbs[j]

            }
        }

        println("size : $length")
    }

    private fun solutionKotlinStyle(target: Int, numbs: IntArray) {
        var length = numbs.size
        numbs.indices.forEach { i ->
            var counter = 0
            var sum = 0
            (i until numbs.size).forEach { j ->
                if (sum > target) {
                    return@forEach
                } else if (sum == target && counter < length) {
                    length = counter
                    return@forEach
                }
                counter++
                sum += numbs[j]
            }
        }

        println("kotlin style size : $length")
    }

    fun printHashSet(list: HashSet<SomeData>) {
        list.forEach {
            println("$it -- ${it.hashCode()}")
        }
        println("-------------------------------")
    }

    data class SomeData(
        private val a: Int,
        private val b: String,
    ) {
        //        override fun hashCode(): Int {
//            return 1
//        }
//        override fun hashCode(): Int {
//            return super.hashCode()
//        }
//
//        override fun equals(other: Any?): Boolean {
//            if (this === other) return true
//            if (javaClass != other?.javaClass) return false
//
//            other as SomeData
//
//            if (a != other.a) return false
//            if (b != other.b) return false
//
//            return true
//        }
    }
}