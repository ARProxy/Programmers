import java.util.*

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }

    println(getMinOperations(a, b))
}

fun getMinOperations(a: Long, b: Long): Int {
    var count = 1
    var current = b

    while (current > a) {
        when {
            current % 10 == 1L -> {
                current /= 10
                count++
            }
            current % 2 == 0L -> {
                current /= 2
                count++
            }
            else -> return -1
        }
    }

    return if (current == a) count else -1
}