import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        return result;
    }
}