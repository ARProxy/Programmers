class Solution {
    fun solution(arr: IntArray): Int {
        //LCM(a, b) = a * b / GCD(a, b)
        //최대 공약수 - 유클리드 알고리즘
        fun gcd(a: Int, b: Int): Int {
            return if (b == 0) a else gcd(b, a % b)
        }
        //최소 공배수
        fun lcm(a: Int, b: Int): Int {
            return a * b / gcd(a, b)
        }
        
        return arr.reduce { acc, num -> lcm(acc, num) }
    }
}