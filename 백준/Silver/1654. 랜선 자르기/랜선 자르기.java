import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lan = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(br.readLine().trim());
            if (lan[i] > max) max = lan[i];
        }

        long lo = 1, hi = max, ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) cnt += lan[i] / mid;

            if (cnt >= N) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}