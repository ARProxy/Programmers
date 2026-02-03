import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        int gcdValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(input[i] - input[j]);
                gcdValue = gcd(gcdValue, diff);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}