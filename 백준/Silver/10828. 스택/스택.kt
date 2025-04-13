import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val sb = StringBuilder()

    val n = scanner.nextInt()
    val stack = IntArray(n)
    var size = 0

    repeat(n) {
        when (val command = scanner.next()) {
            "push" -> {
                val value = scanner.nextInt()
                stack[size] = value
                size++
            }
            "pop" -> {
                sb.append(
                    if (size == 0) -1
                    else stack[--size].also { stack[size] = 0 }
                ).append('\n')
            }
            "size" -> sb.append(size).append('\n')
            "empty" -> sb.append(if (size == 0) 1 else 0).append('\n')
            "top" -> sb.append(if (size == 0) -1 else stack[size - 1]).append('\n')
        }
    }

    print(sb)
}