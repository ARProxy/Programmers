import java.util.*

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0

    val visited = BooleanArray(y + 1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(x to 0)
    visited[x] = true

    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()

        val nexts = listOf(current + n, current * 2, current * 3)

        for (next in nexts) {
            if (next > y || visited[next]) continue
            if (next == y) return count + 1

            visited[next] = true
            queue.add(next to count + 1)
        }
    }

    return -1
    }
}