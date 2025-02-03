import java.util.*

val INF = Int.MAX_VALUE

fun main() {
    val testCase = readln().toInt()

    repeat(testCase) {
        val (n, d, c) = readln().split(" ").map(String::toInt)
        val adj = MutableList(n + 1) { mutableListOf<Pair<Int, Int>>() }

        repeat(d) {
            val (b, a, s) = readln().split(" ").map(String::toInt)
            adj[a].add(Pair(b, s))
        }

        val distance = dijkstra(c, n, adj)
        val infectedComputer = distance.count { it != INF }
        val maxTime = distance.filter { it != INF }.maxOrNull() ?: 0

        println("$infectedComputer $maxTime")
    }
}

fun dijkstra(start: Int, n: Int, adj: MutableList<MutableList<Pair<Int, Int>>>): IntArray {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val distance = IntArray(n + 1) { INF }

    distance[start] = 0
    queue.offer(Pair(start, 0))

    while (queue.isNotEmpty()) {
        val (current, cost) = queue.poll()
        if (cost > distance[current]) continue

        for ((next, time) in adj[current]) {
            if (distance[next] > distance[current] + time) {
                distance[next] = distance[current] + time
                queue.offer(Pair(next, distance[next]))
            }
        }
    }
    return distance
}
