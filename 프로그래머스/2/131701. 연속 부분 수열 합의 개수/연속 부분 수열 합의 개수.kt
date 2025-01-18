class Solution {
    fun solution(elements: IntArray): Int {
        val n = elements.size
        val result = mutableSetOf<Int>()
        val circularArray = (elements + elements).toList() // IntArray를 List로 변환
        for (length in 1..n) {
            for (start in 0 until n) { // 끝 인덱스 수정
                val sum = circularArray.subList(start, start + length).sum()
                result.add(sum)
            }
        }
        return result.size
    }
}