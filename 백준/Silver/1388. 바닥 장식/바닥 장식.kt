fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val tail = MutableList(n) { MutableList(m) { "" } }
    for (i in 0 until n) {
        tail[i] = readln()
            .split("")
            .filter { it.isNotBlank() }
            .map { it.trim() }
            .toMutableList()
    }

    val load = MutableList(n) { MutableList(m) { 0 } }
    //만약 - 일경우 오른쪽으로 체크 |일 경우 아래쪽으로 체크
    //오른쪽 아래쪽으로 갈때는 2중 반복문 필요
    var count = 0
    for ( a in 0 until n ) {
        for( b in 0 until m ) {
            if(load[a][b] == 1) continue
            if(tail[a][b] == "-") {
                var right = b
                while(right < m && tail[a][right] == "-" && load[a][right] == 0) {
                    load[a][right] = 1
                    right++
                }
                count++
            } else if (tail[a][b] == "|") {
                var height = a
                while (height < n && tail[height][b] == "|" && load[height][b] == 0) {
                    load[height][b] = 1
                    height++
                }
                count++
            }

        }
    }
    println(count)
}
