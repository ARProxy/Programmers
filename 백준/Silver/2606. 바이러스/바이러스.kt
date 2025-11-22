fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    
    val graph = mutableMapOf<Int, MutableList<Int>>()
    
    for (i in 1..n) {
        graph[i] = mutableListOf()
    }
    
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a]!!.add(b)
        graph[b]!!.add(a)
    }
    
    val visited = mutableSetOf<Int>()
    val queue = mutableListOf<Int>()
    
    queue.add(1)
    visited.add(1)
    
    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        
        graph[current]?.forEach { neighbor -> 
                                if (neighbor !in visited) {
                                    visited.add(neighbor)
                                    queue.add(neighbor)
                                }}
    }
    
    println(visited.size - 1)
}