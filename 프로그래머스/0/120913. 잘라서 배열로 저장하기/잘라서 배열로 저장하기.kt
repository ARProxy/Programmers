class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        val strArray = my_str.split("")
        var result = arrayOfNulls<String>(strArray.size)
        var temp = ""
    
        for(i in 1 until strArray.size - 1) {
            temp += strArray[i]
            if((strArray.size - 2) == i || i % n == 0) {	
                result[i - 1] = temp
                temp = ""
            }

        }
        return result.filterNotNull().toTypedArray()
    }
}