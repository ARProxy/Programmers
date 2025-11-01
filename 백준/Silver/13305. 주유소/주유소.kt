fun main() {
    val village = readln().toInt()
    val dgree = readln().split(" ").map { it.toInt() }
    val oilPrice = readln().split(" ").map { it.toInt() }

    val oilPriceValue = oilPrice.subList(0, village - 1)

    var result = 0L
    var minPrice = oilPriceValue[0]

    for (i in dgree.indices) {
        minPrice = minOf(minPrice, oilPriceValue[i])
        result += (minPrice.toLong() * dgree[i])
    }

    println(result)
}