import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    
    val n = br.readLine().toInt()
    val budget = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val sum = br.readLine().toInt()
    
    var upperLimit = budget.maxOf { it }
    
    while (true) {
        val compareSum = budget.sumOf { it.coerceAtMost(upperLimit) }
        
        if (compareSum <= sum) break
        upperLimit--
    }
    
    println(upperLimit)
}