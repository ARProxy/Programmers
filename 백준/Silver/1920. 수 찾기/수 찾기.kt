fun main() {
    val n = readln().toInt()
    val nValues = readln().split(" ").map { it.toInt() }.toSet()
    val m = readln().toInt()
    val mValues = readln().split(" ").map { it.toInt() }

    val result = mValues.map { if (it in nValues) "1" else "0" }
    println(result.joinToString("\n"))
}