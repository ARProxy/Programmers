class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        
	    // val result = arrayOfNulls<String>(quiz.size)
        // 위 코드 타입은 Array<String?> 이기 떄문에 type misatch error
        val result = Array(quiz.size) { "" }
        var count = 0
        for(data in quiz) {
            var dataArray = data.split(" ")
            
            val first = dataArray[0].toInt()
            val second = dataArray[2].toInt()
            val third = dataArray[4].toInt()
            var compare = 0
            
            if(dataArray[1].equals("-")) {
                compare = first - second
            } else {
                compare = first + second
            }
            
            if(compare == third) {
                result[count] = "O"
            } else {
                result[count] = "X"
            }
            count++
        }
        return result
    }
}