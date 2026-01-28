import java.lang.StringBuilder

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1)
    val result = IntArray(m)
    val sb = StringBuilder()
    
    fun dfs(depth: Int) {
        if(depth == m) {
            sb.append(result.joinToString(" ")).append('\n')
            return
        }
        
        for(i in 1..n) {
            if(!visited[i]) {
                visited[i] = true
                result[depth] = i
                dfs(depth + 1)
                visited[i] = false
            }
        }
    }
    dfs(0)
    print(sb)
}