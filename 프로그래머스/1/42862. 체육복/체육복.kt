class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val pair = mutableListOf<Pair<Int, Int>>()
        
        val realLost = lost.filter { it !in reserve }.sorted()
        val realReserve = reserve.filter { it !in lost }.sorted().toMutableList()
        
        dong@ for (i in 1..n) {
            if (i in realLost) {
                pair.add(Pair(i, -1))
                continue@dong
            }
            if (i in realReserve) {
                pair.add(Pair(i, 1))
                continue@dong
            }
            pair.add(Pair(i, 0))
        }

        for (i in realLost) {
            if (i - 1 in realReserve) {
                realReserve.remove(i - 1)
            } else if (i + 1 in realReserve) {
                realReserve.remove(i + 1)
            } else {
                continue
            }
            pair.find { it.first == i }?.let { pair.remove(it); pair.add(Pair(i, 0)) }
        }

        return pair.count { it.second >= 0 }
    }
}
