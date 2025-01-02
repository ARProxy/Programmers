class Solution {
    fun solution(A: String, B: String): Int {
        if(A == B) {
            return 0
        }
        
        var inputArray = A.split("").filter {
            it.isNotEmpty()
        }.toTypedArray()
        
        var resultArray = arrayOfNulls<String>(inputArray.size)
        var count = 0
        
        while(count < inputArray.size) {
            val lastChar = inputArray.last()
            for(i in inputArray.size - 1 downTo 1) {
                inputArray[i] = inputArray[i - 1]
            }
            inputArray[0] = lastChar
            count++
            
            if (B == inputArray.joinToString("")) {
                return count
            }
        }
        return -1
    }
}