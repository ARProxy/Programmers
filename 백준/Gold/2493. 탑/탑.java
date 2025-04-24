import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] tops = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentHeight = tops[i];
            while (!stack.isEmpty() && stack.peek()[1] < currentHeight) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek()[0] + 1).append(" ");
            }
            stack.push(new int[]{i, currentHeight});
        }
        System.out.println(sb.toString());
    }
}