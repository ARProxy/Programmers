fun main() {
    val n = readln().toInt()
    val matrix = Array(n) {
        readln().split(" ").map(String::toInt).toIntArray()
    }
    
    for(k in 0..< n) {
        for(i in 0..< n) {
            for(j in 0..< n) {
                if(matrix[i][k] == 1 && matrix[k][j] == 1) {
                    matrix[i][j] = 1
                }
            }
        }
    }
    
     matrix.forEach { println(it.joinToString(" ")) }
}