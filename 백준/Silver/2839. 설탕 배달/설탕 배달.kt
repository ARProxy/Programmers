fun main() {
    val sugar = readln().toInt()
    val kg3 = 3
    val kg5 = 5
    
    val dp = IntArray(sugar + 1) { Int.MAX_VALUE }
    
    dp[0] = 0
    
    for (i in 1..sugar) {
        if (i >= kg3 && dp[i - kg3] != Int.MAX_VALUE) {
            dp[i] = minOf(dp[i], dp[i - kg3] + 1)
        }
        if (i >= kg5 && dp[i - kg5] != Int.MAX_VALUE) {
            dp[i] = minOf(dp[i], dp[i - kg5] + 1)
        }
    }
    
    println(
    	if (dp[sugar] == Int.MAX_VALUE) -1 else dp[sugar]
    )
}