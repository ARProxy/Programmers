fun main() {
    val input = readln().split(" ")
    val n = input[0].toInt()
    val d = input[1].toInt()
    
    val loads = Array(n) {
        readln().split(" ").map {
            it.toInt()
        }
    }
    
    val dp = IntArray(d + 1) { it }
    
    for(i in 0..d) {
        if(i > 0) dp[i] = minOf(dp[i], dp[i - 1] + 1)
        
        for(load in loads) {
            val start = load[0]
            val end = load[1]
            val length = load[2]
            
            if(i == start && end <= d) {
                dp[end] = minOf(dp[end], dp[start] + length)
            }
        }
    }
    println(dp[d])
}