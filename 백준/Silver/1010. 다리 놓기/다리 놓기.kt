import java.math.BigInteger

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        println(combination(m, n))
    }
}

fun combination(n: Int, r: Int): BigInteger {
    if (r == 0 || n == r) return BigInteger.ONE

    var result = BigInteger.ONE
    var denominator = BigInteger.ONE

    for (i in 0 until r) {
        result = result.multiply(BigInteger.valueOf((n - i).toLong()))
        denominator = denominator.multiply(BigInteger.valueOf((i + 1).toLong()))
    }
    
    return result.divide(denominator)
}