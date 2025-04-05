import java.util.*

fun main() {
    val n = readln().toInt()
    val jumps = readln().split(" ").map(String::toInt)
    val visited = BooleanArray(n) { false }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    
    queue.add(Pair(0, 0))
    visited[0] = true
    
    while(queue.isNotEmpty()) {
        val (current, count) = queue.poll()
        
        if(current == n - 1) {
            println(count)
            return
        }
        
        for(next in current + 1 .. minOf(n - 1, current + jumps[current])) {
            if(!visited[next]) {
                visited[next] = true
                queue.add(Pair(next, count + 1))
            }
        }
    }
    
    println(-1)
}