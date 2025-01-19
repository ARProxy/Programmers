class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var sum = 0L
        for(i in 1..count) {
            sum += i * price
        }
        val answer = money - sum
        return if( answer < 0 ) -answer else 0
    }
}