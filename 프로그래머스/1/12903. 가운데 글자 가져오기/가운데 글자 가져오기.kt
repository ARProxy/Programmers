class Solution {
    fun solution(s: String): String {
        val arr = s.split("").filter { it.isNotEmpty() }
        var result = ""
        val index = (arr.size / 2)
        
        if(arr.size % 2 == 0) {
            result = arr[index - 1] + arr[index]
        } else {
            result = arr[index]
        }
        return result
    }
}