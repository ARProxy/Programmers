fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = Array(n) { readln().map { it.digitToInt() }.toIntArray() }
    val b = Array(n) { readln().map { it.digitToInt() }.toIntArray() }

    fun flip(x: Int, y: Int) {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                a[x + i][y + j] = 1 - a[x + i][y + j]
            }
        }
    }

    var count = 0
    for (i in 0..n - 3) {
        for (j in 0..m - 3) {
            if (a[i][j] != b[i][j]) {
                flip(i, j)
                count++
            }
        }
    }

    val isEqual = (0 until n).all { i -> (0 until m).all { j -> a[i][j] == b[i][j] } }
    println(if (isEqual) count else -1)
}
