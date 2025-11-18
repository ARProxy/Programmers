import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val selected = mutableListOf<Int>()
    
    dfs(1, n, m, selected)
}

fun dfs(
    start: Int,
    n: Int,
    m: Int,
    selected: MutableList<Int>
) {
    if (selected.size == m) {
        println(selected.joinToString(" "))
        return
    }
    
    for (i in start..n) {
        selected.add(i)
        dfs(i + 1, n, m, selected)
        selected.removeLast()
    }
}