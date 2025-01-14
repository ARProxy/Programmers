fun main() {
    val ( rows, cols ) = readln().split(" ").map { it.toInt() }
    val grid = mutableListOf<List<Int>>()
    
    repeat(rows) {
        val row = readln().split(" ").map { it.toInt() }
        grid.add(row)
    }
    
    val zeroRaw = List(cols + 2) { 0 }
    val expanded = mutableListOf<List<Int>>().apply {
        add(zeroRaw)
        grid.forEach { row -> 
                      val expandedRow = listOf(0) + row + listOf(0)
                      add(expandedRow)
                     }
        add(zeroRaw)
    }
    
    val visited = Array(rows + 2) { BooleanArray(cols + 2) }
    val map = mutableMapOf<Int, Int>()
    
    fun dfs(x: Int, y:Int, index: Int) {
        if(x < 0 || x >= rows + 2 || y < 0 || y >= cols + 2 || visited[x][y] || expanded[x][y] == 0) return
        
        visited[x][y] = true
        map[index] = map.getOrDefault(index, 0) + 1
        
        dfs(x - 1, y, index) // 위
        dfs(x + 1, y, index) // 아래
        dfs(x, y - 1, index) // 왼쪽
        dfs(x, y + 1, index) // 오른쪽
        
    }
    
    var index = 0
        for (i in 1..rows) {
            for (j in 1..cols) {
                if (!visited[i][j] && expanded[i][j] == 1) {
                    dfs(i, j, index)
                    index++
                }
            }
        }

        val maxValue = map.values.maxOrNull() ?: 0

        println(map.size.toString() + "\n" + maxValue)
}