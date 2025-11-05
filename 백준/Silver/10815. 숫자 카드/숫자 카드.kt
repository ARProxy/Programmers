fun main() {
    val n = readln().toInt()
    val nCard = readln().split(" ").map { it.toInt() }.toSet()
    val m = readln().toInt()
    val mCard = readln().split(" ").map { it.toInt() }
    
    println(mCard
           .joinToString(" ") {
               if (it in nCard) "1" else "0"
           })
}