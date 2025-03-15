fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val weights = readln().split(" ").map(String::toInt).sorted()
    
    var left = 0
    var right = n - 1
    var count = 0
    
    while(left < right) {
        val sum = weights[left] + weights[right]
        
        if(sum <= k) {
            count++
            left++
            right--
        } else {
            right--
        }
    }
    println(count)
}