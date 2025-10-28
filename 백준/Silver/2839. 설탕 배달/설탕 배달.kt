fun main() {
    val n = readln().toInt()
    var result = -1
    var temp = n

    //5kg 봉지를 최대한 많이 사용하는 방식으로
    var fiveCount = temp / 5
    
    while (fiveCount >= 0) {
        //5키로 전부 쓴 후 남는 무게.
        val remaining = temp - (fiveCount * 5)
        
        if (remaining % 3 == 0) {
            val threeCount = remaining / 3
            result = fiveCount + threeCount
            break
        }
        //반복문 돌 때마다 5키로 하나씩 줄이고 재시도
        fiveCount--
    }
    /**
     * 5Kg 봉지 개수를 줄여가며 모든 조합을 시도하는 방식으로
     */
    println(result)
}