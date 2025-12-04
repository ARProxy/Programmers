import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }.sorted()

    val m = br.readLine().toInt()
    val queries = br.readLine().split(" ").map { it.toInt() }

    fun lowerBound(arr: List<Int>, target: Int): Int {
        var lo = 0
        var hi = arr.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (arr[mid] >= target) hi = mid
            else lo = mid + 1
        }
        return lo
    }

    fun upperBound(arr: List<Int>, target: Int): Int {
        var lo = 0
        var hi = arr.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (arr[mid] > target) hi = mid
            else lo = mid + 1
        }
        return lo
    }

    val sb = StringBuilder()
    queries.forEach { q ->
        val count = upperBound(cards, q) - lowerBound(cards, q)
        sb.append(count).append(' ')
    }

    println(sb.toString().trimEnd())
}