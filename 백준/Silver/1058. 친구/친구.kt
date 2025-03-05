import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val friends = Array(n) { readLine()!!.toCharArray() }

    fun countTwoFriends(start: Int): Int {
        val visited = BooleanArray(n)
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        visited[start] = true
        queue.add(start to 0)

        var count = 0
        while (queue.isNotEmpty()) {
            val (person, depth) = queue.poll()
            if (depth == 2) continue

            for (i in 0 until n) {
                if (!visited[i] && friends[person][i] == 'Y') {
                    visited[i] = true
                    queue.add(i to depth + 1)
                    count++
                }
            }
        }
        return count
    }

    val maxTwoFriends = (0 until n).maxOf { countTwoFriends(it) }
    println(maxTwoFriends)
}
