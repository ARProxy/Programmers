fun main() {
    val n = readln().toInt()
    val step = IntArray(n) { readln().toInt() }
    
    val dp = IntArray(n + 1) { Int.MIN_VALUE }
    
    dp[0] = step[0]
    if (n > 1) dp[1] = step[0] + step[1]
    if (n > 2) dp[2] = maxOf(
        step[0] + step[2], step[1] + step[2]
    )
    
    for (i in 3..< n) {
        dp[i] = maxOf(
            dp[i - 3] + step[i - 1] + step[i],
            dp[i - 2] + step[i]
        )
    }
    //어렵다..
    println(dp[n - 1])
}