class Solution {
    fun solution(phone_number: String): String {
        return phone_number
            .split("")
            .filter { it.isNotEmpty() }
            .mapIndexed { index, char -> 
                if(index < phone_number.length - 4) "*" else char
            }
            .joinToString("")
    }
}