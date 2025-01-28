import java.util.*

fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }
        val map = mutableMapOf<Int, MutableList<Int>>()
        for( i in 0 until m) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            map.computeIfAbsent(a) { mutableListOf() }.add(b)
            map.computeIfAbsent(b) { mutableListOf() }.add(a)
        }

        for (key in map.keys) {
            map[key]?.sort()
        }

        //DFS
        val dfsResult = mutableListOf<Int>()
        val visitedDfs = BooleanArray(n + 1)
        fun dfs(node: Int) {
            if(visitedDfs[node]) return
            visitedDfs[node] = true
            dfsResult.add(node)
            for(neighbor in map[node] ?: emptyList()) {
                dfs(neighbor)
            }
        }

        val bfsResult = mutableListOf<Int>()
        val visitedBfs = BooleanArray(n + 1)
        fun bfs(start: Int) {
            val queue: Queue<Int> = LinkedList()
            queue.add(start)
            visitedBfs[start] = true

            while(queue.isNotEmpty()) {
                val node = queue.poll()
                bfsResult.add(node)
                for(neighbor in map[node] ?: emptyList()) {
                    if(!visitedBfs[neighbor]) {
                        visitedBfs[neighbor] = true
                        queue.add(neighbor)
                    }
                }
            }
        }

        dfs(v)
        bfs(v)

        println(dfsResult.joinToString(" "))
        println(bfsResult.joinToString(" "))
}