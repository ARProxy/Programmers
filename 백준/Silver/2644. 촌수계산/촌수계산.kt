import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val (x, y) = readLine().split(" ").map { it.toInt() }
    
    val m = readLine().toInt()
    val graph = mutableMapOf<Int, MutableList<Int>>()
    
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableListOf() }.add(b)
        graph.getOrPut(b) { mutableListOf() }.add(a)
    }
    
    val queue = ArrayDeque<Int>()
    val visited = mutableSetOf<Int>()
    
    queue.add(x)
    visited.add(x)
    
    var depth = 0
    
    while (queue.isNotEmpty()) {
        val size = queue.size
        
        repeat(size) {
            val current = queue.poll()
            
            if (current == y) {
                println(depth)
                return@with
            }
            
            graph[current]?.forEach { next -> 
                if (next !in visited) {
                    visited.add(next)
                    queue.add(next)
                }
            }
        }
        
        depth++
    }
    
    println(-1)
}