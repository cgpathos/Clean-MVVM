package net.appthos.mvvm

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.abs


class KotlinTest {
    companion object {
        const val HEAD = 0
        const val TAIL = 1
    }


    @Test
    fun test1() {
        assertEquals(solution1(intArrayOf(1, 0, 0, 1, 0, 0)), 2)
        assertEquals(solution1(intArrayOf(1, 1, 0, 1, 0, 0)), 3)
        assertEquals(solution1(intArrayOf(1, 1, 1, 1, 1, 0)), 1)
    }


    private fun solution1(A: IntArray): Int {
        var head = 0
        var tail = 0


        for (coin in A) {
            if (coin == HEAD) {
                head++
            }
            else if (coin == TAIL) {
                tail++
            }
        }

        return Math.min(head, tail)
    }


    @Test
    fun test2() {
        val org =
            "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11"

        val expected =
            "Warsaw02.jpg\n" +
                "London1.png\n" +
                "Warsaw01.png\n" +
                "Paris2.jpg\n" +
                "Paris1.jpg\n" +
                "London2.jpg\n" +
                "Paris3.png\n" +
                "Warsaw03.jpg\n" +
                "Warsaw09.png\n" +
                "Warsaw07.jpg\n" +
                "Warsaw06.jpg\n" +
                "Warsaw08.jpg\n" +
                "Warsaw04.png\n" +
                "Warsaw05.png\n" +
                "Warsaw10.jpg"

        val sol = solution2(org)
        assertEquals(sol, expected)
    }

    val cityMap = HashMap<String, ArrayList<Photo>>()

    private fun solution2(S: String): String {
        val SArr = S.split("\n")
        val newPhotoList = ArrayList<Photo>()

        for (s in SArr) {
            val photo = convertTOData(s)

            if (cityMap[photo.city] == null) {
                cityMap[photo.city] = ArrayList()
            }
            cityMap[photo.city]?.add(photo)
            newPhotoList.add(photo)
        }

        for ((key, value) in cityMap) {
            val cityGroup = value.sortedBy { it.date }.toList()
            cityMap[key] = cityGroup as ArrayList<Photo>
        }


        val solution = StringBuffer()
        for (photo in newPhotoList) {
            solution.append(newFileName(photo))
        }

        return solution.toString().trim()
    }

    private fun newFileName(photo: Photo): String {
        val cityGroup = cityMap[photo.city]!!
        val count = cityGroup.size
        val index = cityGroup.indexOf(photo) + 1
        val formattedIndex = when {
            count < 10  -> {
                "$index"
            }
            count < 100 -> {
                "%02d".format(index)
            }
            else        -> {
                "%d03d".format(index)
            }
        }

        return "${photo.city}${formattedIndex}.${photo.extension}\n"
    }

    private fun convertTOData(raw: String): Photo {
        val rawArr = raw.split(", ")
        val fileArr = rawArr[0].split(".")

        return Photo(fileArr[0],
            fileArr[1],
            rawArr[1],
            LocalDateTime.parse(rawArr[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        )
    }

    data class Photo(
        val orgFileName: String,
        val extension: String,
        val city: String,
        val date: LocalDateTime,
    )


    @Test
    fun test3() {
        assertEquals(solution3(intArrayOf(60, 80, 40), intArrayOf(2, 3, 5), 5, 2, 200), 5)
        assertEquals(solution3(intArrayOf(40, 40, 100, 80, 20), intArrayOf(3, 3, 2, 2, 3), 3, 5, 200), 6)
    }


    private fun solution3(A: IntArray, B: IntArray, M: Int, X: Int, Y: Int): Int {
        val elevatorQueue = LinkedList<Pair<Int, Int>>()
        val N = A.size

        var weightLimit = 0
        var moveCount = 0
        var currentFloor = 0

        var idx = 0
        while (idx < N) {
            while (idx < N && (weightLimit + A[idx] <= Y) && (elevatorQueue.size + 1 <= X)) {
                elevatorQueue.add(Pair(A[idx], B[idx]))
                weightLimit += A[idx]
                idx++
            }

            while (elevatorQueue.size > 0) {
                val (_, floor) = elevatorQueue.pop()

                if (currentFloor != floor) {
                    moveCount++
                    currentFloor = floor
                }
            }

            if (currentFloor != 0) {
                moveCount++
                currentFloor = 0
            }
            weightLimit = 0
        }

        println(moveCount)
        return moveCount
    }

    @Test
    fun test4() {

        assertEquals(solution4(intArrayOf(1, 2, 5, 9, 9), 5), 2)
    }

    private fun solution4(A: IntArray, X: Int): Int {

        A.forEachIndexed { index, i -> if (X == i) return index }

        return -1
    }

    @Test
    fun t1() {
        assertEquals(sol1(3, 2, intArrayOf(2, 1, 1, 0, 1)), "11100,10001")
        assertEquals(sol1(2, 3, intArrayOf(0, 0, 1, 1, 2)), "IMPOSSIBLE")
        assertEquals(sol1(2, 2, intArrayOf(2, 0, 2, 0)), "1010,1010")
    }

    private fun sol1(U: Int, L: Int, C: IntArray): String {
        val solutionArr = Array<IntArray>(2) { IntArray(C.size) }
        var counterU = U
        var counterL = L

        for ((idx, columnSum) in C.withIndex()) {
            if (columnSum == 0) {
                solutionArr[0][idx] = 0
                solutionArr[1][idx] = 0
            }
            else if (columnSum == 2) {
                solutionArr[0][idx] = 1
                solutionArr[1][idx] = 1

                counterU--
                counterL--
            }
            else if (columnSum == 1) {
                if (counterU > 0) {
                    solutionArr[0][idx] = 1
                    counterU--
                }
                else if (counterL > 0) {
                    solutionArr[1][idx] = 1
                    counterL--
                }
            }
        }

        if (solutionArr[0].sum() == U && solutionArr[1].sum() == L) {
            val row1 = solutionArr[0].joinToString("")
            val row2 = solutionArr[1].joinToString("")
            return "$row1,$row2"
        }

        return "IMPOSSIBLE"
    }

    @Test
    fun t2() {
        val org = "my.song.mp3 11b\n" +
            "greatSong.flac 1000b\n" +
            "not3.txt 5b\n" +
            "video.mp4 200b\n" +
            "game.exe 100b\n" +
            "mov!e.mkv 10000b"
        val expect = "music 1011b\n" +
            "images 0b\n" +
            "movies 10200b\n" +
            "other 105b"
        assertEquals(sol2(org), expect)
    }

    private fun sol2(S: String): String {
        val notDigitRegex = "[^\\d.]".toRegex()

        val fileListArray = S.split("\n")
        var musicSizeSum = 0
        var imagesSizeSum = 0
        var moviesSizeSum = 0
        var otherSizeSum = 0

        for (fileInfo in fileListArray) {
            val (file, bytes) = fileInfo.split(" ")
            val extension = file.substringAfterLast(".")
            val size = bytes.replace(notDigitRegex, "").toInt()

            when (extension) {
                "mp3", "aac", "flac" -> musicSizeSum += size
                "jpg", "bmp", "gif" -> imagesSizeSum += size
                "mp4", "avi", "mkv" -> moviesSizeSum += size
                else                 -> otherSizeSum += size
            }
        }

        return "music ${musicSizeSum}b\n" +
            "images ${imagesSizeSum}b\n" +
            "movies ${moviesSizeSum}b\n" +
            "other ${otherSizeSum}b"
    }

    @Test
    fun t3() {
        assertEquals(sol3(intArrayOf(3, 2, -2, 5, -3)), 3)
        assertEquals(sol3(intArrayOf(1, 1, 2, -1, 2, -1)), 1)
        assertEquals(sol3(intArrayOf(1, 2, 3, -4)), 0)
    }

    private fun sol3(A: IntArray): Int {
        var largestPairInter = 0

        for ((idx, targetInt) in A.withIndex()) {

            for (subIdx in idx until A.size) {
                val compareInt = A[subIdx]
                if(targetInt * -1 == compareInt) {
                    val absTargetInt = abs(targetInt)
                    if(absTargetInt > largestPairInter) {
                        largestPairInter = absTargetInt
                    }
                    break
                }
            }
        }

        return largestPairInter
    }
}