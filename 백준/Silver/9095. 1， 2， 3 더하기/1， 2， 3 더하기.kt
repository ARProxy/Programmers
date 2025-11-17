fun main() {
    val t = readln().toInt()
    repeat(t) {
        println(countWays(readln().toInt()))
    }
}

fun countWays(n: Int): Int {
    val ways = mutableListOf<List<Int>>()
    
    fun backtracking(remaining: Int, current: MutableList<Int>) {
        if (remaining == 0) {
            ways.add(current.toList())
            return
        }
        
        for (i in 1..3) {
            if (remaining >= i) {
                current.add(i)
                backtracking(remaining - i, current)
                current.removeLast()
            }
        }
    }
    
    backtracking(n, mutableListOf())
    return ways.size
}