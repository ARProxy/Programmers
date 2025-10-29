fun main() {
    val input = readln()
    val groups = input.split("-")
    var result = groups[0].split("+").sumOf { it.toInt() }
    
    for (i in 1..< groups.size) {
        result -= groups[i].split("+").sumOf { it.toInt() }
    }
    
    println(result)
}