fun main() {
    val (n, l) = readln().split(" ").map(String::toInt)

        var result = "-1"
        for (len in l..100) {
            val temp = len * (len - 1) / 2
            val remain = n - temp

            if (remain < 0) break

            if (remain % len == 0) {
                val start = remain / len
                if (start >= 0) {
                    result = (start..<start + len).joinToString(" ")
                    break
                }
            }
        }
        println(result)
}