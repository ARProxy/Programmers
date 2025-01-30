import java.util.*

lateinit var visited: Array<IntArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    visited = Array(m) { IntArray(n) { 0 } }

    val tomatoes = Array(m) { row -> 
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (tomatoes[i][j] == 1) {
                queue.add(Pair(i, j))
                visited[i][j] = 1
            }
        }
    }

    println(bfs(queue, tomatoes, m, n))
}

private fun bfs(queue: Queue<Pair<Int, Int>>, tomatoes: Array<IntArray>, m: Int, n: Int): Int {
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.poll()

        for (i in 0 until 4) {
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nx in 0 until m && ny in 0 until n && tomatoes[nx][ny] == 0) {
                queue.add(Pair(nx, ny))
                tomatoes[nx][ny] = tomatoes[cx][cy] + 1
            }
        }
    }

    var maxDays = 0
    for (i in 0 until m) {
        for (k in 0 until n) {
            if (tomatoes[i][k] == 0) { // 수정: `j` → `k`
                return -1
            }
            maxDays = maxOf(maxDays, tomatoes[i][k])
        }
    }
    return maxDays - 1
}
