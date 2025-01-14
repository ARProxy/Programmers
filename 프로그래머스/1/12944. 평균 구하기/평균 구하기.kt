class Solution {
    fun solution(arr: IntArray): Double {
        val total = arr.fold(0) { acc, i -> acc + i}
        return total.toDouble() / arr.size
    }
}