import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m, v) = readLine().split(" ").map { it.toInt() }
    
    val graph = Array(n + 1) { mutableListOf<Int>() }
    
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    
    graph.forEach { it.sort() }
    
    val dfsVisited = BooleanArray(n + 1)
    val dfsResult = mutableListOf<Int>()
    
    fun dfs(node: Int) {
        dfsVisited[node] = true
        dfsResult.add(node)
        
        for (next in graph[node]) {
            if (!dfsVisited[next]) dfs(next)
        }
    }
    
    fun bfs(start: Int): List<Int> {
        val visited = BooleanArray(n + 1)
        val queue = LinkedList<Int>()
        val result = mutableListOf<Int>()
        
        queue.offer(start)
        visited[start] = true
        
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            result.add(node)
            
            for (next in graph[node]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.offer(next)
                }
            }
        }
        
        return result
    }
    
    dfs(v)
    println(dfsResult.joinToString(" "))
    
    val bfsResult = bfs(v)
    println(bfsResult.joinToString(" "))
}