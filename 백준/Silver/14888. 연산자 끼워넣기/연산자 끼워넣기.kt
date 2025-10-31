fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }.toIntArray()
    val operators = readln().split(" ").map { it.toInt() }.toIntArray()
    
    var maxResult = Int.MIN_VALUE
    var minResult = Int.MAX_VALUE
    
    fun dfs(
        index: Int, 
        currentResult: Int, 
        plus: Int,
        minus: Int,
        multiply: Int,
        divide: Int
    ) {
        if (index == n) {
            maxResult = maxOf(maxResult, currentResult)
            minResult = minOf(minResult, currentResult)
            return
        }
        
        val nextNumber = numbers[index]
        
        if (plus > 0) {
            dfs(index + 1, currentResult + nextNumber, plus - 1, minus, multiply, divide)
        }
        
        if (minus > 0) {
            dfs(index + 1, currentResult - nextNumber, plus, minus - 1, multiply, divide)
        }
        
        if (multiply > 0) {
            dfs(index + 1, currentResult * nextNumber, plus, minus, multiply - 1, divide)
        }
        
        if (divide > 0) {
            dfs(index + 1, currentResult / nextNumber, plus, minus, multiply, divide - 1)
        }
    }
    
    dfs(1, numbers[0], operators[0], operators[1], operators[2], operators[3])
    
    println(maxResult)
    println(minResult)
}
