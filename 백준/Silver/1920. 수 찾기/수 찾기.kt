fun main() {
    val n = readln().toInt()
    val nSet = readln().split(" ").map { it.toInt() }.toSet()
    val m = readln().toInt()
    
    readln().split(" ").map { it.toInt() }.forEach {
        println( if (it in nSet) 1 else 0 )
    }
}