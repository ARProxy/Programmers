import java.util.*

fun main() {
    val n = readln().toInt()
    val query = readln().split(" ").map { it.toInt() }
    val personA = query[0]
    val personB = query[1]
    val m = readln().toInt()
    val graph = mutableMapOf<Int, MutableList<Int>>()
    
    for( i in 1..n) {
        graph[i] = mutableListOf()
    }
    
    repeat(m) {
        val (parent, child) = readln().split(" ").map { it.toInt() }
        graph[parent]?.add(child)
        graph[child]?.add(parent)
    }
    
    println(findRelation(graph, personA, personB, n))
}

fun findRelation(
    graph:Map<Int, List<Int>>,
    start: Int,
    target: Int,
    n: Int
): Int {
    val visited = BooleanArray(n + 1) { false }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(start, 0))
    visited[start] = true
    
    while(queue.isNotEmpty()) {
        val (current, distance) = queue.poll()
        
        if(current == target) {
            return distance
        }
        
        graph[current]?.forEach {
            neighbor -> 
            if(!visited[neighbor]) {
                visited[neighbor] = true
                queue.add(Pair(neighbor, distance + 1))
            }
        }
    }
    return -1
}