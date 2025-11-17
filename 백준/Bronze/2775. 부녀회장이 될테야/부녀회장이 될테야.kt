fun main() {
    val t = readln().toInt()
    
    val dp = Array(15) { IntArray(15) }
    
    for (i in 1..14) {
        dp[0][i] = i
    }
    
    for (k in 1..14) {
        for (n in 1..14) {
            dp[k][n] = dp[k][n - 1] + dp[k - 1][n]
        }
    }
    
    repeat(t) {
        val k = readln().toInt()
        val n = readln().toInt()
        println(dp[k][n])
    }
}