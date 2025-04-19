 data class Box(val from: Int, val to: Int, val count: Int)

    fun main() {
        val (n, c) = readln().split(" ").map(String::toInt)
        val m = readln().toInt()

        val boxes = mutableListOf<Box>()
        repeat(m) {
            val (from, to, count) = readln().split(" ").map(String::toInt)
            boxes.add(Box(from, to, count))
        }

        boxes.sortWith(compareBy({ it.to }, { it.from }))

        val truck = IntArray(n + 1)
        var answer = 0

        for( (from, to, count) in boxes ) {
            val maxLoad = (from until to).map { truck[it] }.maxOrNull() ?: 0
            val canLoad = minOf(c - maxLoad, count)

            if(canLoad <= 0) continue

            for(i in from until to) {
                truck[i] += canLoad
            }

            answer += canLoad
        }

        println(answer)
    }