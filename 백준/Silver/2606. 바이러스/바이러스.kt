fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    
    val warm = mutableMapOf<Int, MutableList<Int>>()
    
    for(i in 0..< m) {
        val (a, b) = readln().split(" ").map(String::toInt)
        warm.computeIfAbsent(a) { mutableListOf() }.add(b)
        warm.computeIfAbsent(b) { mutableListOf() }.add(a)
    }
    
     val set = mutableSetOf<Int>()
     set.add(1)
    
    val queue = ArrayDeque<Int>()
    queue.add(1)
    
    var count = 0
    
    while(queue.isNotEmpty()) {
        val key = queue.removeFirst()
        val neighbors = warm.remove(key) ?: continue
        
        for(i in neighbors) {
            if(i !in set) {
                set.add(i)
                queue.add(i)
                count++
            }
        }
    }
    println(count)
}