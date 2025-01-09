class Solution {
    fun solution(s: String): Int {
        val intArray = s.split("").filter { it.isNotEmpty() }
        println(intArray)
        if (intArray[0] == "-") {
            return parsing(intArray)
        }
        return intArray.joinToString("").toInt()
    }

    fun parsing(array: List<String>): Int {
        var str = ""
        for (i in 1 until array.size) {
            str += array[i]
        }
        return str.toInt() * -1
    }
}