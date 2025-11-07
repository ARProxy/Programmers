fun main() {
    val n = readln().toInt()
    val budget = readln().split(" ").map { it.toInt() }
    val sum = readln().toInt()
    
    var upperLimit = budget.maxOf { it }
    
    while(true) {
        val compareSum = budget.sumOf { it.coerceAtMost(upperLimit) }
        
        if (compareSum <= sum) break
        upperLimit--
    }
    
    println(upperLimit)
}