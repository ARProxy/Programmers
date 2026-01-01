import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        int n = A.length();
        int m = B.length();
        
        int minDiff = n;
        
        for (int i = 0; i <= m - n; i++) {
            int diff = 0;
            for (int j = 0; j < n; j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }
            minDiff = Math.min(minDiff, diff);
        }
        
        System.out.println(minDiff);
    }
}