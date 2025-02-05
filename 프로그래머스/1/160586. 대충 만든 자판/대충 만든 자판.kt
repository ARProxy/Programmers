class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val minPresses = mutableMapOf<Char, Int>()

        for ((keyIndex, key) in keymap.withIndex()) {
            key.forEachIndexed { pressCount, char ->
                minPresses[char] = minPresses.getOrDefault(char, Int.MAX_VALUE).coerceAtMost(pressCount + 1)
            }
        }

        return targets.map { target ->
            var totalPresses = 0
            for (char in target) {
                val presses = minPresses[char] ?: return@map -1
                totalPresses += presses
            }
            totalPresses
        }.toIntArray()
    }
}