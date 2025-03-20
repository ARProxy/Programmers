fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val coins = IntArray(n) { readln().toInt() }
    
    var remaining = k
    var count = 0
    
    for(coin in coins.reversed()) {
        if(remaining == 0) break
        
        val used = remaining / coin
        remaining %= coin
        count += used
    }
    println(count)
}