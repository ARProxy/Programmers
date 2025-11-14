import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val t = IntArray(n + 1)
    val p = IntArray(n + 1)
    
    for (i in 1..n) {
        val (time, pay) = readLine().split(" ").map { it.toInt() }
        t[i] = time
        p[i] = pay
    }
    
    val dp = IntArray(n + 2)
    
    for (i in n downTo 1) {
        val nextDay = i + t[i]
        
        if (nextDay > n + 1) {
            dp[i] = dp[i + 1]
        } else {
            dp[i] = maxOf(dp[i + 1], p[i] + dp[nextDay])
        }
    }
    
    println(dp[1])
}