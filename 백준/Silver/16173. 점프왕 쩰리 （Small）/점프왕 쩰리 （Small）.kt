fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(n) }
    
    var found = false
    
    fun dfs(x: Int, y: Int) {
        if (x < 0 || x >= n || y < 0 || y >= n) return
        
        if (visited[x][y]) return
        
        visited[x][y] = true
        
        if (map[x][y] == -1) {
            found = true
            return
        }
        
        val jump = map[x][y]
        
        dfs(x, y + jump)
        dfs(x + jump, y)
    }
    
    dfs(0, 0)
    
    println(if (found) "HaruHaru" else "Hing")
}