fun main() {
    val n = readln().toInt()
        val heights = readln().split(" ").map { it.toLong() }

        var maxVisible = 0

        for (i in 0 until n) {
            var visible = 0

            for (j in 0 until n) {
                if (i == j) continue

                var canSee = true
                val xi = i.toDouble()
                val yi = heights[i].toDouble()
                val xj = j.toDouble()
                val yj = heights[j].toDouble()

                val slope = (yj - yi) / (xj - xi)

                for (k in (minOf(i, j) + 1)..<maxOf(i, j)) {
                    val xk = k.toDouble()
                    val expectedY = yi + slope * (xk - xi)

                    if (heights[k] >= expectedY) {
                        canSee = false
                        break
                    }
                }

                if (canSee) visible++
            }

            maxVisible = maxOf(maxVisible, visible)
        }

        println(maxVisible)
}