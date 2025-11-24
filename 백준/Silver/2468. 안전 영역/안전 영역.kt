import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    
    val array = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    
    val height = Array(n + 2) { IntArray(n + 2) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            height[i + 1][j + 1] = array[i][j]
        }
    }
    
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    
    var maxSafeZones = 1
    
    for (water in 1..100) {
        val visited = Array(n + 2) { BooleanArray(n + 2) }
        var safeZones = 0
        
        for (i in 1..n) {
            for (j in 1..n) {
                if (height[i][j] > water && !visited[i][j]) {
                    bfs(height, visited, i, j, water, dx, dy)
                    safeZones++
                }
            }
        }
        
        maxSafeZones = maxOf(maxSafeZones, safeZones)
    }
    
    println(maxSafeZones)
}

fun bfs(
    height: Array<IntArray>,
    visited: Array<BooleanArray>,
    startX: Int,
    startY: Int,
    water: Int,
    dx: IntArray,
    dy: IntArray
) {    
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true
    
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        
        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            
            if (height[nx][ny] > water && !visited[nx][ny]) {
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
            }
        }
    }
}