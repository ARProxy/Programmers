import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long score = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long[] rank = new long[N];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank[i] = Long.parseLong(st.nextToken());
            }
        }

        if (N == P && score <= rank[N - 1]) {
            System.out.println(-1);
            return;
        }

        int ranking = 1;
        for (int i = 0; i < N; i++) {
            if (rank[i] > score) {
                ranking++;
            } else {
                break;
            }
        }

        System.out.println(ranking);
    }
}