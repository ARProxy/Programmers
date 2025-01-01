class Solution {
    fun solution(common: IntArray): Int {
        val diff1 = common[1] - common[0]
    val diff2 = common[2] - common[1]
    
    if (diff1 == diff2) {
    	return common[common.size - 1] + diff1
    }
    
    val ratio: Int = common[1] / common[0]
    return common[common.size - 1] * ratio
    }
}