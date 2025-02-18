import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val clothes = readln()
        .split(" ")
        .filter { it.isNotEmpty() }
        .map(String::toInt)
        .toTypedArray()
    Arrays.sort(clothes)
    
    var count = 0
    var start = 0
    var end = n - 1
    
    while(start < end) {
        val sum = clothes[start] + clothes[end]
        when {
            sum == m -> {
                count++
                start++
                end--
            }
            sum < m -> start++
            else -> end--
        }
    }
    println(count)
}