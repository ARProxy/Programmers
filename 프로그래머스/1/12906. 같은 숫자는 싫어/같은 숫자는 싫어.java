import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temp = new int[arr.length];
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                temp[count++] = arr[i];
            }
        }
        return Arrays.copyOf(temp, count);
    }
}