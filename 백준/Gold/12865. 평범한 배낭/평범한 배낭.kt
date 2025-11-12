import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val items = List(n) {
        val (w, v) = readLine().split(" ").map { it.toInt() }
        Pair(w, v)
    }
    
    val dp = IntArray(k + 1)
    
    for ((weight, value) in items) {
        for (w in k downTo weight) {
            dp[w] = maxOf(dp[w], dp[w - weight] + value)
        }
    }
    //ㅎㅎ
    println(dp[k])
}