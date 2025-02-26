class Solution {
    fun solution(s: String): IntArray {
        var str = s
        var transformCount = 0
        var zeroCount = 0
        
        while(str != "1") {
            val removedZero = str.count { it == '0' }
            zeroCount += removedZero
            
            str = str.filter { it == '1' }.length.toString(2)
            transformCount++
        }
        
        return intArrayOf(transformCount, zeroCount)
    }
}