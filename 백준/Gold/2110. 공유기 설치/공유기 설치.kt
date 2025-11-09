fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    
    val houses = IntArray(n)
    repeat(n) {
        houses[it] = readln().toInt()
    }
    houses.sort()
    
    var left = 1
    var right = houses[n - 1] - houses[0]
    var answer = 1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        
        if (canInstall(houses, c, mid)) {
            answer = mid
            left = mid + 1
        } else {
            right = mid -1
        }
    }
    
    println(answer)
}

private fun canInstall(houses: IntArray, c: Int, distance: Int): Boolean {
    var count = 1
    var lastPosition = houses[0]
    
    for (i in 1..<houses.size) {
        if (houses[i] - lastPosition >= distance) {
            count++
            lastPosition = houses[i]
            
            if (count >= c) return true
        }
    }
    
    return count >= c
}