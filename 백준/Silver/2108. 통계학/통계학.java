import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] count = new int[8001];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            count[num + 4000]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        sb.append(Math.round((double) sum / n)).append("\n");

        int median = 0;
        int maxCount = 0;
        int cumulative = 0;
        int medianPos = (n + 1) / 2;
        boolean medianFound = false;

        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
            }
        }

        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == 0) continue;

            cumulative += count[i];
            if (!medianFound && cumulative >= medianPos) {
                median = i - 4000;
                medianFound = true;
            }

            if (count[i] == maxCount) {
                modes.add(i - 4000);
            }
        }

        int mode = modes.size() >= 2 ? modes.get(1) : modes.get(0);

        sb.append(median).append("\n");
        sb.append(mode).append("\n");
        sb.append(max - min);

        System.out.println(sb);
    }
}