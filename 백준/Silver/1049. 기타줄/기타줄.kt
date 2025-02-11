import kotlin.math.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val packages = mutableListOf<Int>()
    val singles = mutableListOf<Int>()
    
    repeat(m) {
        val (p, s) = readln().split(" ").map(String::toInt)
        packages.add(p)
        singles.add(s)
    }
    
    val minPackage = packages.minOrNull() ?: 0
    val minSingle = singles.minOrNull() ?: 0
    
    val onlyPackageCost = ((n + 5) / 6) * minPackage
    val onlySingleCost = n * minSingle
    val mixedCost = (n / 6) * minPackage + (n % 6) * minSingle
    
    println(min(onlyPackageCost, min(onlySingleCost, mixedCost)))
} 