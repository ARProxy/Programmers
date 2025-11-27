fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val campus = Array(n) { readln().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }
    
    var startX = 0
    var startY = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (campus[i][j] == 'I') {
                startX = i
                startY = j
                break
            }
        }
    }
    
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    
    var peopleCount = 0
    
    fun dfs(x: Int, y: Int) {
        if (x < 0 || x >= n || y < 0 || y >= m) return
        
        if (visited[x][y] || campus[x][y] == 'X') return
        
        visited[x][y] = true
        
        if (campus[x][y] == 'P') {
            peopleCount++
        }
        
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            dfs(nx, ny)
        }
    }
    
    dfs(startX, startY)
   
    println(if (peopleCount == 0) "TT" else peopleCount)
}