fun main() {
    val (H, W) = readLine()!!.split(" ").map(String::toInt)
    val heights = readLine()!!.split(" ").map(String::toInt)

    var totalWater = 0

    for (level in H downTo 1) {
        val blockPositions = heights
            .mapIndexedNotNull { idx, h -> if (h >= level) idx else null }

        if (blockPositions.size <= 1) continue

        val left = blockPositions.first()
        val right = blockPositions.last()
        val widthBetween = right - left + 1
        val blocksBetween = blockPositions.size

        totalWater += (widthBetween - blocksBetween)
    }

    println(totalWater)
}