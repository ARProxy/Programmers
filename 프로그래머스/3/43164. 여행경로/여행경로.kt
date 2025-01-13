class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val ticketMap = tickets.groupBy( {it[0]}, {it[1]} )
            .mapValues { it.value.sorted().toMutableList() }
            
        val result = mutableListOf<String>()
        
        fun dfs(current: String) {
            while(ticketMap[current]?.isNotEmpty() == true) {
                val next = ticketMap[current]?.removeAt(0) ?: break
                dfs(next)
            }
            result.add(current)
        }
        dfs("ICN")
        return result.reversed().toTypedArray()
    }
}