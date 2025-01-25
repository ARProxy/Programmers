import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
        val map = mutableMapOf<Int, MutableList<Int>>()

        // 간선 정보를 입력받아 양방향 그래프 생성
        for (i in 0 until m) {
            val (u, v) = readln().split(" ").map(String::toInt)
            map.computeIfAbsent(u) { mutableListOf() }.add(v)
            map.computeIfAbsent(v) { mutableListOf() }.add(u)
        }
        val visited = BooleanArray(n + 1)
        var count = 0

        // 모든 정점에 대해 탐색
        for (i in 1..n) {
            if (!visited[i]) {
                count++
                val queue: Queue<Int> = LinkedList()
                queue.offer(i)

                // BFS를 이용한 탐색
                while (queue.isNotEmpty()) {
                    val current = queue.poll()
                    if (!visited[current]) {
                        visited[current] = true
                        map[current]?.forEach { neighbor ->
                            if (!visited[neighbor]) {
                                queue.offer(neighbor)
                            }
                        }
                    }
                }
            }
        }

        println(count)
}