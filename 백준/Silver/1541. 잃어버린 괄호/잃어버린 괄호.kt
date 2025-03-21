fun main() {
    val input = readln()
    
    val parts = input.split("-")
    
    var result = parts[0].split("+").sumOf(String::toInt)
    
    for(i in 1..< parts.size) {
        result -= parts[i].split("+").sumOf(String::toInt)
    }
    println(result)
}