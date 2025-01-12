class Solution {
    fun solution(s: String): String {
        val str = s.split(" ")
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (i in str) {
            if(i.toInt() < min) {
                min = i.toInt()
            }
            if(i.toInt() > max) {
                max = i.toInt()
            }
        }
        return arrayOf(min, max).joinToString(" ")
    }
}