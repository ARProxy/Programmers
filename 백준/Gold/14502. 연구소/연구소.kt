import java.util.*

fun main() {
    Laboratory().laboratory()
}

class Laboratory {

    private lateinit var lab: Array<IntArray>
    private var n = 0
    private var m = 0
    private val emptyArea = mutableListOf<Pair<Int, Int>>()
    private val virus = mutableListOf<Pair<Int, Int>>()
    private var maxSafeArea = 0
    private var safeArea = 0

    fun laboratory() {
        val (rows, cols) = readln().split(" ").map { it.toInt() }
        n = rows
        m = cols
        lab = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

        for (i in 0..<n) {
            for (j in 0..<m) {
                when (lab[i][j]) {
                    0 -> {
                        emptyArea.add(i to j)
                        safeArea++
                    }
                    2 -> virus.add(i to j)
                }
            }
        }

        buildWall(0, 0)

        println(maxSafeArea)
    }

    private fun buildWall(index: Int, count: Int) {
        if (count == 3) {
            maxSafeArea = maxOf(maxSafeArea, bfs(safeArea - 3))
            return
        }
        for (i in index until emptyArea.size) {
            val (x, y) = emptyArea[i]
            lab[x][y] = 1 // 벽 설치
            buildWall(i + 1, count + 1)
            lab[x][y] = 0 // 벽 해제 (백트래킹)
        }
    }

    private fun bfs(safeArea: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val copyLab = lab.map { it.copyOf() }.toTypedArray()
        var safeCount = safeArea

        virus.forEach(queue::add)

        val dx = listOf(-1, 1, 0, 0)
        val dy = listOf(0, 0, -1, 1)

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0..<n && ny in 0..<m && copyLab[nx][ny] == 0) {
                    copyLab[nx][ny] = 2
                    queue.add(nx to ny)
                    safeCount--
                }
            }
        }
        return safeCount
    }
}