fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map(String::toInt).toMutableList()
    val b = readln().split(" ").map(String::toInt)
    
    a.sort()
    val sortedB = b.sortedDescending()
    
    val s = a.zip(sortedB).sumOf { it.first * it.second }
    
    println(s)
}