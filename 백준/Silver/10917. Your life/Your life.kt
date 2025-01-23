import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    
    val graph = HashMap<Int, MutableList<Int>>().apply {
        for( i in 1..n ) {
            put(i, mutableListOf())
        }
    }
    
    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        graph[x]?.add(y)
    }
    
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(n + 1)
    val distance = IntArray(n + 1)
    
    queue.offer(1)
    visited[1] = true
    
    while(queue.isNotEmpty()) {
        val current = queue.poll()
        
        if(current == n) {
            println(distance[current])
            return
        }
        
        graph[current]?.forEach { next ->
            if (!visited[next]) {
                queue.offer(next)
                visited[next] = true
                distance[next] = distance[current] + 1
            }
        }
    }
    println(-1)
}