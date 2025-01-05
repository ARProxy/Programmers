class Solution {
    fun solution(answers: IntArray): IntArray {
        val supo1 = arrayOf(1, 2, 3, 4, 5)
        val supo2 = arrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val supo3 = arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val result = arrayOfNulls<Int>(3)
        var point1 = 0
        var point2 = 0
        var point3 = 0

        for (i in answers.indices) {
            if (answers[i] == supo1[i % supo1.size]) {
                point1++
            }
            if (answers[i] == supo2[i % supo2.size]) {
                point2++
            }
            if (answers[i] == supo3[i % supo3.size]) {
                point3++
            }
        }

        val max = maxOf(point1, point2, point3)

        if (max == point1) {
            result[0] = 1
        }
        if (max == point2) {
            result[1] = 2
        }
        if (max == point3) {
            result[2] = 3
        }

        return result.filterNotNull().toIntArray()
    }
}