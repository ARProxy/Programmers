class Solution {
    fun solution(ingredient: IntArray): Int {
        val stack = mutableListOf<Int>()
        val bugger = listOf(1,2,3,1)
        var count = 0
        
        for (i in ingredient) {
            stack.add(i)
            
            if (stack.size >= 4 && stack.takeLast(4) == bugger) {
                repeat(4) { stack.removeAt(stack.size - 1) }
                count++
            }
        }
        return count
    }
}