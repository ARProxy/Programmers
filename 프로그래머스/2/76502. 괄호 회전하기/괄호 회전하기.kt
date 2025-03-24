class Solution {
    fun solution(s: String): Int {
        val n = s.length
        var count = 0

        for (i in 0 until n) {
            val rotated = s.drop(i) + s.take(i)
            if (isValid(rotated)) count++
        }

        return count
    }

    private fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val matching = mapOf(')' to '(', ']' to '[', '}' to '{')

        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack.addLast(char)
                ')', ']', '}' -> {
                    if (stack.isEmpty() || stack.removeLast() != matching[char]) return false
                }
            }
        }

        return stack.isEmpty()
    }
}