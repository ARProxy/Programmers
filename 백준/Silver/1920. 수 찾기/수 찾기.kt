fun main() {
    val n = readln().toInt()
    val nValues = readln().split(" ").map { it.toInt() }.toSet()
    val m = readln().toInt()
    val mValues = readln().split(" ").map { it.toInt() }

    println(mValues
        .joinToString("\n") {
            if (it in nValues) "1" else "0"
    })
}