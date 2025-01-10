class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var countZero = 0;
        var countWin = 0;
        for( i in 0 until win_nums.size){
            if(lottos[i] == 0) {
                countZero++
            } else {
                for(j in 0 until win_nums.size){
                    if(lottos[i] == win_nums[j]){
                        countWin++
                    }
                }
            }
        }
        val sum = countWin + countZero
        val result1 = if (sum in 1..6) 7 - sum else 6
        val result2 = if(countWin in 1..6) 7 - countWin else 6
        return intArrayOf(result1, result2)
    }
}