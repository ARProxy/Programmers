import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val budget = readLine().split(" ").map { it.toInt() }.toIntArray()
    val sum = readLine().toInt()
    
    var left = 0
    var right = budget.maxOf { it }
    var result = 0
    
    while (left <= right) {
        val mid = (left + right) / 2
        val compareSum = budget.sumOf { it.coerceAtMost(mid).toLong() }
        
        if (compareSum <= sum) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    
    println(result)
}