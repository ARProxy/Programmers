import java.util.*

fun main() {
    val n = readln().toInt()
    val stones = readln().split(" ").filter{ it.isNotEmpty() }.map { it.toInt() } 
    val start = readln().toInt() - 1 

    val visited = BooleanArray(n)
    visited[start] = true

    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    
    var count = 1

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val jump = stones[current]

        val left = current - jump
        if (left >= 0 && !visited[left]) {
            visited[left] = true
            queue.add(left)
            count++
        }

        val right = current + jump
        if (right < n && !visited[right]) {
            visited[right] = true
            queue.add(right)
            count++
        }
    }
    println(count)
}