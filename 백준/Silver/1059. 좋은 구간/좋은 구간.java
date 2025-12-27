import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<Integer> S = new HashSet<>();
        for (int i = 0; i < L; i++) {
            S.add(Integer.parseInt(st.nextToken()));
        }
        
        int n = Integer.parseInt(br.readLine().trim());
        
        if (S.contains(n)) {
            System.out.println(0);
            return;
        }
        
        int left = 0;
        for (int x : S) {
            if (x < n) {
                left = Math.max(left, x);
            }
        }
        
        int right = Integer.MAX_VALUE;
        for (int x : S) {
            if (x > n) {
                right = Math.min(right, x);
            }
        }
        
        long countA = n - left;
        long countB = right - n;
        
        long answer = countA * countB - 1;
        
        System.out.println(answer);
    }
}