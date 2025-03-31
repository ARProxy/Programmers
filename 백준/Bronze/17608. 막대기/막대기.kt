fun main() {
    val n = readln().toInt()
    val array = IntArray(n) { readln().toInt() }
    
    var count = 0
    var maxHeight = 0
    
    for( i in n - 1 downTo 0 ) {
        if(array[i] > maxHeight) {
            count++
            maxHeight = array[i]
        }
    }
    println(count)
}