class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var minTime = 1L
        var maxTime = times.maxOrNull()!!.toLong() * n
        while(minTime < maxTime) {
            val mid = (minTime + maxTime) / 2
            val total = times.fold(0L) { acc, time -> acc + mid / time }
            
            if(total >= n) {
                maxTime = mid
            } else {
                minTime = mid + 1
            }
        }
        return minTime
    }
}