class Solution {
    fun solution(babbling: Array<String>): Int {
        val words = arrayOf("aya", "ye", "woo", "ma")
    var count = 0

    for (word in babbling) {
        var temp = word
        var prev = ""
        var isValid = true

        while (temp.isNotEmpty()) {
            var found = false

            for (w in words) {
                if (temp.startsWith(w)) {
                    if (prev == w) {
                        isValid = false
                        break
                    }
                    prev = w
                    temp = temp.removePrefix(w)
                    found = true
                    break
                }
            }
            
            if (!found) {
                isValid = false
                break
            }
        }

        if (isValid) count++
    }

    return count
    }
}