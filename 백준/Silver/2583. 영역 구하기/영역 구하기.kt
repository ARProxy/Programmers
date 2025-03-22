import java.util.*

data class Point(val x: Int, val y: Int)

fun main() {
    val (m, n, k) = readLine()!!.split(" ").map { it.toInt() }
    val grid = Array(m) { BooleanArray(n) }
    val visited = Array(m) { BooleanArray(n) }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine()!!.split(" ").map { it.toInt() }
        for (y in y1 until y2) {
            for (x in x1 until x2) {
                grid[y][x] = true
            }
        }
    }

    val directions = listOf(
        Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0)
    )

    fun bfs(start: Point): Int {
        val queue: Queue<Point> = LinkedList()
        queue.add(start)
        visited[start.y][start.x] = true
        var area = 1

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for ((dx, dy) in directions) {
                val nx = x + dx
                val ny = y + dy
                if (nx in 0 until n && ny in 0 until m &&
                    !visited[ny][nx] && !grid[ny][nx]) {
                    visited[ny][nx] = true
                    queue.add(Point(nx, ny))
                    area++
                }
            }
        }

        return area
    }

    val areas = mutableListOf<Int>()

    for (y in 0 until m) {
        for (x in 0 until n) {
            if (!visited[y][x] && !grid[y][x]) {
                areas.add(bfs(Point(x, y)))
            }
        }
    }

    areas.sort()
    println(areas.size)
    println(areas.joinToString(" "))
}