class Solution {
    fun solution(citations: IntArray): Int {
        citations.sort()
        var temp = citations.size
        var result = 0
        
        while(temp > 0) {
            val h = temp
            var over = 0
            
            for(i in citations.indices) {
                if(citations[i] >= h) {
                    over++
                }
            }
            
            if(over >= h) {
                result = h
                break
            }
            temp--
        }
        return result
    }
}