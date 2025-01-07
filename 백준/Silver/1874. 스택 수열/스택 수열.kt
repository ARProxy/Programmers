import java.util.*

fun main() {
    val n = readln()!!.toInt()
    val sequence = IntArray(n) {
        readln().toInt()
    }
    val stack = Stack<Int>()
    val operation = mutableListOf<String>()
    var current = 1
    
    for(num in sequence) {
        while(current <= num) {
            stack.push(current++)
            operation.add("+")
        }
        
        if(stack.peek() == num) {
            stack.pop()
            operation.add("-")
        } else {
            println("NO")
            return
        }
    }
    println(operation.joinToString("\n"))
}