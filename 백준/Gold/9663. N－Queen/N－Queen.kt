fun main() {
    val n = readln().toInt()
    println(solveNQueen(n))
}

fun solveNQueen(n: Int): Int {
    var count = 0
    val cols = BooleanArray(n)
    val diag1 = BooleanArray(2 * n - 1)
    val diag2 = BooleanArray(2 * n - 1)
    
    fun dfs(row: Int) {
        if (row == n) {
            count++
            return
        }
        
        for (col in 0..<n) {
            val d1 = row - col + n - 1
            val d2 = row + col
            
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                cols[col] = true
                diag1[d1] = true
                diag2[d2] = true
                
                dfs(row + 1)
                
                cols[col] = false
                diag1[d1] = false
                diag2[d2] = false
            }
        }
    }
    
    dfs(0)
    return count
}