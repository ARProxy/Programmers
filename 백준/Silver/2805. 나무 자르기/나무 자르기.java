import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long[] tree = new long[n];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            if (tree[i] > max) max = tree[i];
        }
        
        long lo = 0, hi = max, ans = 0;
        
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long sum = 0;
            
            for (int i = 0; i < n; i++) {
                if (tree[i] > mid) sum += tree[i] - mid;
            }
            
            if (sum >= m) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
}