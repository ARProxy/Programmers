import java.util.*

data class Position(val x: Int, val y: Int, val moves: Int)

fun minKnightMoves(l: Int, startX: Int, startY: Int, targetX: Int, targetY: Int): Int {
    if (startX == targetX && startY == targetY) return 0

    val directions = arrayOf(
        Pair(-2, -1), Pair(-2, 1), Pair(-1, -2), Pair(-1, 2),
        Pair(1, -2), Pair(1, 2), Pair(2, -1), Pair(2, 1)
    )

    val visited = Array(l) { BooleanArray(l) }
    val queue: Queue<Position> = LinkedList()

    queue.add(Position(startX, startY, 0))
    visited[startX][startY] = true

    while (queue.isNotEmpty()) {
        val (x, y, moves) = queue.poll()

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0 until l && ny in 0 until l && !visited[nx][ny]) {
                if (nx == targetX && ny == targetY) return moves + 1
                queue.add(Position(nx, ny, moves + 1))
                visited[nx][ny] = true
            }
        }
    }
    return -1
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val t = reader.readLine().toInt()

    repeat(t) {
        val l = reader.readLine().toInt()
        val (startX, startY) = reader.readLine().split(" ").map { it.toInt() }
        val (targetX, targetY) = reader.readLine().split(" ").map { it.toInt() }

        writer.write("${minKnightMoves(l, startX, startY, targetX, targetY)}\n")
    }

    writer.flush()
    writer.close()
}